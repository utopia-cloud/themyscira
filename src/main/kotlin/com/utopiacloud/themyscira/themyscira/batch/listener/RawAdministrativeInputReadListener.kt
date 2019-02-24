package com.utopiacloud.themyscira.themyscira.batch.listener

import com.utopiacloud.themyscira.themyscira.ScheduledTasks
import com.utopiacloud.themyscira.themyscira.domain.entity.RawAdministrativeInput
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.ItemReadListener
import org.springframework.batch.item.file.FlatFileParseException
import org.springframework.batch.item.file.transform.IncorrectTokenCountException
import org.springframework.stereotype.Component

@Component("rawAdministrativeInputReadListener")
class RawAdministrativeInputReadListener : ItemReadListener<RawAdministrativeInput> {
    private val log: Logger = LoggerFactory.getLogger(ScheduledTasks::class.java)
    override fun afterRead(item: RawAdministrativeInput) {
//        log.info("afterRead")
        return
    }

    override fun beforeRead() {
//        log.info("beforeRead")
        return
    }

    override fun onReadError(ex: Exception) {
        log.info("onReadError")
        if (ex is FlatFileParseException) {
            log.info(ex.lineNumber.toString())
            log.info(ex.input)
            if (ex.cause is IncorrectTokenCountException) {
                log.info((ex.cause as IncorrectTokenCountException).actualCount.toString())
                log.info((ex.cause as IncorrectTokenCountException).message)
            }
        }
        throw ex
    }

}