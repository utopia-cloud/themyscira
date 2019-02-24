package com.utopiacloud.themyscira.themyscira.batch.configuration

import com.utopiacloud.themyscira.themyscira.application.NpoPortalService
import com.utopiacloud.themyscira.themyscira.batch.item.file.mapping.RawAdministrativeInputFieldSetMapper
import com.utopiacloud.themyscira.themyscira.batch.item.processor.AdministrativeItemProcessor
import com.utopiacloud.themyscira.themyscira.batch.item.writer.ConsoleItemWriter
import com.utopiacloud.themyscira.themyscira.batch.listener.RawAdministrativeInputReadListener
import com.utopiacloud.themyscira.themyscira.domain.entity.RawAdministrativeInput
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.step.skip.AlwaysSkipItemSkipPolicy
import org.springframework.batch.core.step.tasklet.MethodInvokingTaskletAdapter
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResource


@Configuration
@EnableBatchProcessing
class AdministrativeInputBatchConfiguration{
    @Autowired
    lateinit var jobBuilderFactory: JobBuilderFactory

    @Autowired
    lateinit var stepBuilderFactory: StepBuilderFactory

    @Autowired
    lateinit var npoPortalService: NpoPortalService

    @Bean
    fun downloadAndImportAdministrativeDataJob(
            downloadZipAdministrativeStep: Step,
            readCsvAdministrativeStep: Step
    ): Job {
        return jobBuilderFactory.get("downloadAndImportAdministrativeDataJob")
                .incrementer(RunIdIncrementer())
                .start(downloadZipAdministrativeStep)
                .next(readCsvAdministrativeStep)
                .build()
    }

    @Bean
    fun downloadZipAdministrativeStep(downloadZipAdministrativeTasklet: Tasklet): Step {
        return stepBuilderFactory
                .get("downloadZipAdministrativeStep")
                .tasklet(downloadZipAdministrativeTasklet)
                .build()
    }

    @Bean
    fun downloadZipAdministrativeTasklet(): MethodInvokingTaskletAdapter {
        val tasklet = MethodInvokingTaskletAdapter()
        tasklet.setTargetObject(npoPortalService)
        tasklet.setTargetMethod("downloadZipAdministrative")
        return tasklet
    }

    @Bean
    fun readCsvAdministrativeStep(
            rawAdministrativeInputReadListener: RawAdministrativeInputReadListener,
            administrativeCsvWriter: ConsoleItemWriter<RawAdministrativeInput>
    ): Step {
        return stepBuilderFactory.get("readCsvAdministrativeStep")
                .chunk<RawAdministrativeInput, RawAdministrativeInput>(10)
                .faultTolerant()
                .skipPolicy(AlwaysSkipItemSkipPolicy())
                .reader(administrativeCsvReader())
                .listener(rawAdministrativeInputReadListener)
                .processor(administrativeItemProcessor())
                .writer(administrativeCsvWriter)
                .build()
    }

    @Bean
    fun administrativeCsvReader(): FlatFileItemReader<RawAdministrativeInput> {
        return FlatFileItemReaderBuilder<RawAdministrativeInput>()
                .name("administrativeCsvReader")
                .resource(FileSystemResource("downloads/000_AdministrativeInputData_20190223.csv"))
                .encoding("Shift_JIS")
                .linesToSkip(1)
                .delimited()
                .names(RawAdministrativeInput.csvHeader)
                .fieldSetMapper(object : BeanWrapperFieldSetMapper<RawAdministrativeInput>() {
                    init {
                        setTargetType(RawAdministrativeInput::class.java)
                    }
                })
                .build()
    }

    @Bean
    fun administrativeItemProcessor(): AdministrativeItemProcessor {
        return AdministrativeItemProcessor()
    }

    @Bean
    fun administrativeCsvWriter(): ConsoleItemWriter<RawAdministrativeInput> {
        return ConsoleItemWriter()
    }
}

