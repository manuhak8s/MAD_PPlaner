package com.manuha.mobile_pplaner.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface IssueDao {
    @Insert
    fun insert(issue: IssueDb)

    @Query("SELECT * FROM issue")
    fun getAll(): List<IssueDb>

    @Query("SELECT * FROM issue WHERE id = :id")
    fun getById(id: Int): IssueDb?
}