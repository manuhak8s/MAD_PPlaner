package com.manuha.mobile_pplaner.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/** Interface for executing project db operations */
@Dao
interface ProjectDao {
    @Insert
    fun insert(project: ProjectDb)

    @Query("SELECT * FROM project")
    fun getAll(): List<ProjectDb>

    @Query("SELECT * FROM project WHERE id = :id")
    fun getById(id: Int): ProjectDb?

    @Query("DELETE FROM project WHERE id = :id")
    fun delete(id: Int)

    @Update
    fun update(project: ProjectDb)
}