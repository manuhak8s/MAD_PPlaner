package com.manuha.mobile_pplaner.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.ZonedDateTime

@Entity(tableName = "issue")
data class IssueDb(
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    val level: Int,
    val projectId: String,
    val created: ZonedDateTime,
    val updated: ZonedDateTime,
    val deleted: ZonedDateTime,
    val termination: String,
)
