package com.manuha.mobile_pplaner.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.manuha.mobile_pplaner.domain.model.Issue
import java.time.ZonedDateTime

/** Type converters to map between SQLite types and entity types. */
object Converters {
    /** Returns the string representation of the [timestamp]. */
    @TypeConverter
    fun timestampToDb(timestamp: ZonedDateTime?): String? {
        return timestamp?.toString()
    }

    /** Returns the [ZonedDateTime] represented by the [timestamp]. */
    @TypeConverter
    fun timestampFromDb(timestamp: String?): ZonedDateTime? {
        return timestamp?.let {
            ZonedDateTime.parse(it)
        }
    }

    /** Converts a list of issues to a valid db field item as String*/
    @TypeConverter
    fun IssuesListToDb(issues: List<Issue>): String? {
        val gson = Gson()
        val type = object: TypeToken<List<Issue>>() {}.type
        return gson.toJson(issues, type)
    }

    /** Converts a String db field to a vald Issue list*/
    @TypeConverter
    fun IssuesListFromDb(value: String): List<Issue> {
        val gson = Gson()
        val type = object : TypeToken<List<Issue>>() {}.type
        return gson.fromJson(value, type)
    }
}
