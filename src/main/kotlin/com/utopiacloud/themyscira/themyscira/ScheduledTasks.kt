package com.utopiacloud.themyscira.themyscira

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.text.SimpleDateFormat
import java.util.*


@Component
class ScheduledTasks {
    val log = LoggerFactory.getLogger(ScheduledTasks::class.java)

    val dateFormat = SimpleDateFormat("HH:mm:ss")

    @Scheduled(fixedRate = 5000) //which specifies the interval between method invocations measured from the start time of each invocation.
    fun reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(Date()))
    }
}