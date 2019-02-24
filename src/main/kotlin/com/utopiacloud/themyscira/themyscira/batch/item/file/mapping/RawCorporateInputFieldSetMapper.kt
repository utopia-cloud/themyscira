package com.utopiacloud.themyscira.themyscira.batch.item.file.mapping

import com.utopiacloud.themyscira.themyscira.domain.entity.RawCorporateInput
import org.springframework.batch.item.file.mapping.FieldSetMapper
import org.springframework.batch.item.file.transform.FieldSet

class RawCorporateInputFieldSetMapper : FieldSetMapper<RawCorporateInput> {
    override fun mapFieldSet(fieldSet: FieldSet): RawCorporateInput {
        var rawCorporateInput = RawCorporateInput()
        return rawCorporateInput
    }
}