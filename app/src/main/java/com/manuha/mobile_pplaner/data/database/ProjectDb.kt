package com.manuha.mobile_pplaner.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.manuha.mobile_pplaner.domain.model.Issue
import java.time.ZonedDateTime

@Entity(tableName = "project")
data class ProjectDb(
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    val issues: List<Issue>,
    val created: ZonedDateTime,
    val updated: ZonedDateTime,
    val deleted: ZonedDateTime,
    val termination: String,
)