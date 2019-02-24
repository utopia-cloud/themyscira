package com.utopiacloud.themyscira.themyscira.batch.item.processor

import com.utopiacloud.themyscira.themyscira.ScheduledTasks
import com.utopiacloud.themyscira.themyscira.domain.entity.RawAdministrativeInput
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.item.ItemProcessor

class AdministrativeItemProcessor : ItemProcessor<RawAdministrativeInput, RawAdministrativeInput> {
    private val log: Logger = LoggerFactory.getLogger(ScheduledTasks::class.java)
    override fun process(item: RawAdministrativeInput): RawAdministrativeInput? {
//        log.info("AdministrativeItemProcessor")
//        log.info(item.toString())
        return item
    }
}