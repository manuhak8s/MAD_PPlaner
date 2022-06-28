package com.manuha.mobile_pplaner.domain.model

import java.time.ZonedDateTime

class Project private constructor(
    val id: Int,
    val title: String,
    val description: String,
    val issues: List<Issue>,
    val created: ZonedDateTime,
    val updated: ZonedDateTime,
    val deleted: ZonedDateTime,
    val termination: ZonedDateTime
)