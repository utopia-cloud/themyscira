package com.utopiacloud.themyscira.themyscira.batch.configuration

import com.utopiacloud.themyscira.themyscira.application.NpoPortalService
import com.utopiacloud.themyscira.themyscira.batch.item.file.mapping.RawCorporateInputFieldSetMapper
import com.utopiacloud.themyscira.themyscira.batch.listener.RawCorporateInputReadListener
import com.utopiacloud.themyscira.themyscira.batch.item.processor.CorporateItemProcessor
import com.utopiacloud.themyscira.themyscira.batch.item.writer.ConsoleItemWriter
import com.utopiacloud.themyscira.themyscira.domain.entity.RawCorporateInput
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
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResource


@Configuration
@EnableBatchProcessing
class CorporateInputConfiguration {
    @Autowired
    lateinit var jobBuilderFactory: JobBuilderFactory

    @Autowired
    lateinit var stepBuilderFactory: StepBuilderFactory

    @Autowired
    lateinit var npoPortalService: NpoPortalService

    @Bean
    fun downloadAndImportCorporateDataJob(
            downloadZipCorporateStep: Step,
            readCsvCorporateStep: Step
    ): Job {
        return jobBuilderFactory.get("downloadAndImportCorporateDataJob")
                .incrementer(RunIdIncrementer())
                .start(downloadZipCorporateStep)
                .next(readCsvCorporateStep)
                .build()
    }

    @Bean
    fun downloadZipCorporateStep(downloadZipCorporateTasklet: Tasklet): Step {
        return stepBuilderFactory
                .get("downloadZipCorporateStep")
                .tasklet(downloadZipCorporateTasklet)
                .build()
    }

    @Bean
    fun downloadZipCorporateTasklet(): MethodInvokingTaskletAdapter {
        val tasklet = MethodInvokingTaskletAdapter()
        tasklet.setTargetObject(npoPortalService)
        tasklet.setTargetMethod("downloadZipCorporate")
        return tasklet
    }

    @Bean
    fun readCsvCorporateStep(
            rawCorporateInputReadListener: RawCorporateInputReadListener,
            corporateCsvWriter: ConsoleItemWriter<RawCorporateInput>
    ): Step {
        return stepBuilderFactory.get("readCsvCorporateStep")
                .chunk<RawCorporateInput, RawCorporateInput>(10)
                .faultTolerant()
                .skipPolicy(AlwaysSkipItemSkipPolicy())
                .reader(corporateCsvReader())
                .listener(rawCorporateInputReadListener)
                .processor(corporateItemProcessor())
                .writer(corporateCsvWriter)
                .build()
    }

    @Bean
    fun corporateCsvReader(): FlatFileItemReader<RawCorporateInput> {
        return FlatFileItemReaderBuilder<RawCorporateInput>()
                .name("corporateCsvReader")
                .resource(FileSystemResource("downloads/000_CorporateInputData_20190220.csv"))
                .encoding("Shift_JIS")
                .linesToSkip(1)
                .delimited()
                .names(RawCorporateInput.csvHeader)
                .fieldSetMapper(RawCorporateInputFieldSetMapper())
//                    init {
//                        setTargetType(RawCorporateInput::class.java)
//                    }
//                })
                .build()
    }

    @Bean
    fun corporateItemProcessor(): CorporateItemProcessor {
        return CorporateItemProcessor()
    }

    @Bean
    fun corporateCsvWriter(): ConsoleItemWriter<RawCorporateInput> {
        return ConsoleItemWriter()
    }
}

