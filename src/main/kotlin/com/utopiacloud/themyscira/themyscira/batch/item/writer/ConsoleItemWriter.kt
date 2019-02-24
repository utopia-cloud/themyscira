package com.utopiacloud.themyscira.themyscira.batch.item.writer

import com.utopiacloud.themyscira.themyscira.ScheduledTasks
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.item.ItemWriter

class ConsoleItemWriter<T> : ItemWriter<T> {
    private val log: Logger = LoggerFactory.getLogger(ScheduledTasks::class.java)

    override fun write(items: MutableList<out T>) {
        log.info("ConsoleItemWriter start")
        items.forEach { item -> log.info(item.toString()) }
        log.info("ConsoleItemWriter end")
    }
}