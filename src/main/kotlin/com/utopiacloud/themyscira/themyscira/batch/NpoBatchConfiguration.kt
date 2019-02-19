package com.utopiacloud.themyscira.themyscira.batch

import com.utopiacloud.themyscira.themyscira.ScheduledTasks
import com.utopiacloud.themyscira.themyscira.application.NpoPortalService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.step.tasklet.MethodInvokingTaskletAdapter
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemWriter
import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.batch.item.file.LineMapper
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder
import org.springframework.batch.item.file.mapping.DefaultLineMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResource


@Configuration
@EnableBatchProcessing
class NpoBatchConfiguration {
    @Autowired
    lateinit var jobBuilderFactory: JobBuilderFactory

    @Autowired
    lateinit var stepBuilderFactory: StepBuilderFactory

    @Autowired
    lateinit var npoPortalService: NpoPortalService

    @Bean
    fun downloadAndImportCorporateDataJob(downloadZipCorporateStep: Step, readCsvCorporateStep: Step): Job {
        return jobBuilderFactory.get("downloadAndImportCorporateDataJob")
                .incrementer(RunIdIncrementer())
                .start(downloadZipCorporateStep)
                .start(readCsvCorporateStep)
                .build()
    }

    @Bean
    fun downloadZipCorporateStep(downloadZipTasklet: Tasklet): Step {
        return stepBuilderFactory
                .get("downloadZipCorporateStep")
                .tasklet(downloadZipTasklet)
                .build()
    }

    @Bean
    fun downloadZipCorporateTasklet(): MethodInvokingTaskletAdapter {
        val tasklet = MethodInvokingTaskletAdapter()
        tasklet.setTargetObject(npoPortalService)
        tasklet.setTargetMethod("downloadZipAdministrative")
        return tasklet
    }

    @Bean
    fun readCsvCorporateStep(corporateCsvWriter: ConsoleItemWriter<String>): Step {
        return stepBuilderFactory.get("readCsvCorporateStep")
                .chunk<String, String>(10)
                .reader(corporateCsvReader())
                .processor(corporateItemProcessor())
                .writer(corporateCsvWriter)
                .build()
    }

    @Bean
    fun corporateCsvReader(): FlatFileItemReader<String> {
        return FlatFileItemReaderBuilder<String>()
                .name("corporateCsvReader")
                .resource(FileSystemResource("downloads/000_CorporateInputData_20190218.csv"))
                .encoding("Shift_JIS")
                .lineMapper(DefaultLineMapper())
//                .lineMapper(PassThroughLineMapper())
//                .delimited()
//                .names(arrayOf("firstName", "lastName"))
//                .fieldSetMapper(object : BeanWrapperFieldSetMapper<String>() {
//                    init {
//                        setTargetType(String::class.java)
//                    }
//                })
                .build()
    }

    @Bean
    fun corporateItemProcessor(): CorporateItemProcessor {
        return CorporateItemProcessor()
    }

    @Bean
    fun corporateCsvWriter(): ConsoleItemWriter<String> {
        return ConsoleItemWriter()
    }
}

class PassThroughLineMapper : LineMapper<String> {
    private val log: Logger = LoggerFactory.getLogger(ScheduledTasks::class.java)
    override fun mapLine(line: String, lineNumber: Int): String {
        log.info("PassThroughLineMapper")
        log.info(line)
        return line
    }
}

class ConsoleItemWriter<T> : ItemWriter<T> {
    private val log: Logger = LoggerFactory.getLogger(ScheduledTasks::class.java)

    override fun write(items: MutableList<out T>) {
        log.info("ConsoleItemWriter start")
        items.forEach { item -> log.info(item.toString()) }
        log.info("ConsoleItemWriter end")
    }
}

class CorporateItemProcessor : ItemProcessor<String, String> {
    private val log: Logger = LoggerFactory.getLogger(ScheduledTasks::class.java)
    override fun process(item: String): String? {
        log.info("CorporateItemProcessor")
        log.info(item)
        return item
    }
}