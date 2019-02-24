package com.utopiacloud.themyscira.themyscira.trial

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider
import org.springframework.batch.item.database.JdbcBatchItemWriter
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder
import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import javax.sql.DataSource


@Configuration
@EnableBatchProcessing // it adds many critical beans that support jobs and saves you a lot of leg work. This example uses a memory-based database (provided by @EnableBatchProcessing), meaning that when it’s done, the data is gone.
class BatchConfiguration {

    @Autowired
    lateinit var jobBuilderFactory: JobBuilderFactory

    @Autowired
    lateinit var stepBuilderFactory: StepBuilderFactory

    // tag::readerwriterprocessor[]
    @Bean
    fun reader(): FlatFileItemReader<Person> {
        return FlatFileItemReaderBuilder<Person>()
                .name("personItemReader")
                .resource(ClassPathResource("sample-data.csv"))
                .delimited()
                .names(arrayOf("firstName", "lastName"))
                .fieldSetMapper(object : BeanWrapperFieldSetMapper<Person>() {
                    init {
                        setTargetType(Person::class.java)
                    }
                })
                .build()
    }

    @Bean
    fun processor(): PersonItemProcessor {
        return PersonItemProcessor()
    }

    @Bean
    fun writer(dataSource: DataSource): JdbcBatchItemWriter<Person> {
        return JdbcBatchItemWriterBuilder<Person>()
                .itemSqlParameterSourceProvider(BeanPropertyItemSqlParameterSourceProvider())
                .sql("INSERT INTO trial_people (first_name, last_name) VALUES (:firstName, :lastName)")
                .dataSource(dataSource)
                .build()
    }
    // end::readerwriterprocessor[]

    // tag::jobstep[]
//    @Bean
    fun importUserJob(listener: JobCompletionNotificationListener, step1: Step): Job {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build()
    }

    @Bean
    fun step1(writer: JdbcBatchItemWriter<Person>): Step {
        return stepBuilderFactory.get("step1")
                .chunk<Person, Person>(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build()
    }
    // end::jobstep[]
}
