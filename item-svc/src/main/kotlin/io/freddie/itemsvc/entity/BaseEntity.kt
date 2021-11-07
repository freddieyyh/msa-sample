package io.freddie.itemsvc.entity

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity {
    @Column(columnDefinition = "TIMESTAMP")
    lateinit var createdAt: LocalDateTime

    lateinit var createdBy: String
}