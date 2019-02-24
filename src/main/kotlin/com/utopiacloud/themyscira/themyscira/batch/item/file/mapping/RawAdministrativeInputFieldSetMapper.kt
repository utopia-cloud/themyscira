package com.utopiacloud.themyscira.themyscira.batch.item.file.mapping

import com.utopiacloud.themyscira.themyscira.domain.entity.RawAdministrativeInput
import org.springframework.batch.item.file.mapping.FieldSetMapper
import org.springframework.batch.item.file.transform.FieldSet

class RawAdministrativeInputFieldSetMapper : FieldSetMapper<RawAdministrativeInput> {
    override fun mapFieldSet(fieldSet: FieldSet): RawAdministrativeInput {
        var rawAdministrativeInput = RawAdministrativeInput()
        return rawAdministrativeInput
    }
}