package com.manuha.mobile_pplaner.domain.model

import java.time.ZonedDateTime

data class Project (
    val id: Int,
    val title: String,
    val description: String,
    val issues: List<Issue>,
    val created: ZonedDateTime,
    val updated: ZonedDateTime,
    val deleted: ZonedDateTime,
    val termination: ZonedDateTime
)

val demoIssues: List<Issue> = listOf(
    Issue(
        id = 1,
        title = "test issue 1",
        description = "bla bla",
        level = 1,
        created = ZonedDateTime.now(),
        updated = ZonedDateTime.now(),
        deleted = ZonedDateTime.now(),
        termination = ZonedDateTime.now()
    ),
    Issue(
        id = 2,
        title = "test issue 2",
        description = "bla bla bla bla",
        level = 5,
        created = ZonedDateTime.now(),
        updated = ZonedDateTime.now(),
        deleted = ZonedDateTime.now(),
        termination = ZonedDateTime.now()
    )
)
val demoProjects = listOf(

    Project(
        id = 1,
        title = "project 1",
        description = "This is demo project 1.",
        issues = demoIssues,
        created = ZonedDateTime.now(),
        updated = ZonedDateTime.now(),
        deleted = ZonedDateTime.now(),
        termination = ZonedDateTime.now()
    ),
    Project(
        id = 2,
        title = "project 2",
        description = "This is demo project 2.",
        issues = demoIssues,
        created = ZonedDateTime.now(),
        updated = ZonedDateTime.now(),
        deleted = ZonedDateTime.now(),
        termination = ZonedDateTime.now()
    )
)