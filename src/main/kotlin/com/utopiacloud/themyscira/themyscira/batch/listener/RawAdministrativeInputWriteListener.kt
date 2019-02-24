package com.utopiacloud.themyscira.themyscira.batch.listener

import com.utopiacloud.themyscira.themyscira.ScheduledTasks
import com.utopiacloud.themyscira.themyscira.domain.entity.RawAdministrativeInput
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.ItemWriteListener
import org.springframework.stereotype.Component

@Component("rawAdministrativeInputWriteListener")
class RawAdministrativeInputWriteListener : ItemWriteListener<RawAdministrativeInput> {
    private val log: Logger = LoggerFactory.getLogger(ScheduledTasks::class.java)
    override fun afterWrite(items: MutableList<out RawAdministrativeInput>) {
        return
    }

    override fun onWriteError(exception: java.lang.Exception, items: MutableList<out RawAdministrativeInput>) {
        log.info("onWriteError")
        items.forEach { i -> log.info("${i.name}, ${i.addressSub}") }
        throw exception
    }

    override fun beforeWrite(items: MutableList<out RawAdministrativeInput>) {
        return
    }
}