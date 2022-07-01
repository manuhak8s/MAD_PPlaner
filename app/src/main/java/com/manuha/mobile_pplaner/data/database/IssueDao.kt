package com.manuha.mobile_pplaner.data.database

import androidx.room.*

/** Interface for executing issue db operations */
@Dao
interface IssueDao {
    @Insert
    fun insert(issue: IssueDb)

    @Query("SELECT * FROM issue")
    fun getAll(): List<IssueDb>

    @Query("SELECT * FROM issue WHERE id = :id")
    fun getById(id: Int): IssueDb?

    @Query("DELETE FROM issue WHERE id = :id")
    fun delete(id: Int)

    @Update
    fun update(issue: IssueDb)
}