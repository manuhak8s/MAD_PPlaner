package com.manuha.mobile_pplaner.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    version = 4,
    entities = [
        IssueDb::class,
    ]
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun issueDao(): IssueDao
}