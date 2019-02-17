package com.utopiacloud.themyscira.themyscira.trial

import org.slf4j.LoggerFactory
import org.springframework.batch.core.BatchStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.listener.JobExecutionListenerSupport
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component


@Component
class JobCompletionNotificationListener
@Autowired
constructor(
        private val jdbcTemplate: JdbcTemplate
) : JobExecutionListenerSupport() {

    override fun afterJob(jobExecution: JobExecution) {
        if (jobExecution.getStatus() !== BatchStatus.COMPLETED) {
            return
        }
        log.info("!!! JOB FINISHED! Time to verify the results")

        jdbcTemplate.query("SELECT first_name, last_name FROM people") { rs, _ ->
            Person(
                    firstName = rs.getString(1),
                    lastName = rs.getString(2)
            )
        }.forEach { person -> log.info("Found <$person> in the database.") }
    }

    companion object {
        private val log = LoggerFactory.getLogger(JobCompletionNotificationListener::class.java)
    }
}