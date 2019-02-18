package com.utopiacloud.themyscira.themyscira.batch

import com.utopiacloud.themyscira.themyscira.application.NpoPortalService
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.step.tasklet.MethodInvokingTaskletAdapter
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


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
    fun downloadAndImportNpoDataJob(downloadZipStep: Step): Job {
        return jobBuilderFactory.get("downloadAndImportNpoDataJob")
                .incrementer(RunIdIncrementer())
                .start(downloadZipStep)
                .build()
    }

    @Bean
    fun downloadZipStep(downloadZipTasklet: Tasklet): Step {
        return stepBuilderFactory
                .get("downloadZipStep")
                .tasklet(downloadZipTasklet)
                .build()
    }

    @Bean
    fun downloadZipTasklet(): MethodInvokingTaskletAdapter {
        val tasklet = MethodInvokingTaskletAdapter()
        tasklet.setTargetObject(npoPortalService)
        tasklet.setTargetMethod("downloadZipNpo")
        return tasklet
    }
}