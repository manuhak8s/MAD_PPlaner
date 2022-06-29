package com.manuha.mobile_pplaner.domain.model

import java.time.ZonedDateTime

data class Issue (
    val id: Int,
    val title: String,
    val description: String,
    val level: Int,
    val created: ZonedDateTime,
    val updated: ZonedDateTime,
    val deleted: ZonedDateTime,
    val termination: ZonedDateTime
)