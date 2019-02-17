package com.utopiacloud.themyscira.themyscira.domain.entity.base

import java.time.LocalDateTime
import javax.persistence.MappedSuperclass
import javax.persistence.PrePersist
import javax.persistence.PreUpdate


@MappedSuperclass
abstract class TimeRecordingEntity {
    var createdAt: LocalDateTime? = null
    var updatedAt: LocalDateTime? = null

    @PrePersist
    fun onPrePersist() {
        this.createdAt = LocalDateTime.now()
        this.updatedAt = LocalDateTime.now()
    }

    @PreUpdate
    fun onPreUpdate() {
        this.updatedAt = LocalDateTime.now()
    }
}