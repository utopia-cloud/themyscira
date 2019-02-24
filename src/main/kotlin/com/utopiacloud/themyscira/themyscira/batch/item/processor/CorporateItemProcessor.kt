package com.utopiacloud.themyscira.themyscira.batch.item.processor

import com.utopiacloud.themyscira.themyscira.ScheduledTasks
import com.utopiacloud.themyscira.themyscira.domain.entity.RawCorporateInput
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.item.ItemProcessor

class CorporateItemProcessor : ItemProcessor<RawCorporateInput, RawCorporateInput> {
    private val log: Logger = LoggerFactory.getLogger(ScheduledTasks::class.java)
    override fun process(item: RawCorporateInput): RawCorporateInput? {
//        log.info("CorporateItemProcessor")
//        log.info(item.toString())
        return item
    }
}