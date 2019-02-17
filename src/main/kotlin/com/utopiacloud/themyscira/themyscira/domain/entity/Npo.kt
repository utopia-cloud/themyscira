package com.utopiacloud.themyscira.themyscira.domain.entity

import com.utopiacloud.themyscira.themyscira.domain.entity.base.TimeRecordingEntity
import javax.persistence.*


@Entity
@Table(name = "npo")
data class Npo(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,

        var corporateNumber: Long = 0,

        var name: String = ""
) : TimeRecordingEntity()