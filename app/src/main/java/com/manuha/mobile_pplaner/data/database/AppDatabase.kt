package com.manuha.mobile_pplaner.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    version = 8,
    entities = [
        IssueDb::class,
        ProjectDb::class,
    ]
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun issueDao(): IssueDao
    abstract fun projectDao(): ProjectDao
}