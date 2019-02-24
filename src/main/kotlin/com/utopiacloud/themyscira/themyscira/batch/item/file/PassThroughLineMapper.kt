package com.utopiacloud.themyscira.themyscira.batch.item.file

import com.utopiacloud.themyscira.themyscira.ScheduledTasks
import com.utopiacloud.themyscira.themyscira.domain.entity.RawCorporateInput
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.item.file.LineMapper

class PassThroughLineMapper : LineMapper<RawCorporateInput> {
    private val log: Logger = LoggerFactory.getLogger(ScheduledTasks::class.java)
    override fun mapLine(line: String, lineNumber: Int): RawCorporateInput {
        log.info("PassThroughLineMapper")
        log.info(line.toString())
        return RawCorporateInput()
    }
}