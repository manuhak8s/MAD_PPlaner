package com.manuha.mobile_pplaner.data

import com.manuha.mobile_pplaner.App
import com.manuha.mobile_pplaner.data.database.*
import com.manuha.mobile_pplaner.domain.model.Issue
import com.manuha.mobile_pplaner.domain.model.Project

val projectRepo = ProjectRepository(App.database.projectDao())

class ProjectRepository(private val dao: ProjectDao,) {

    fun getAllProjects(): List<Project> = dao.getAll().mapNotNull { projectFromDb(it) }

    fun getProjectById(id: Int): Project? = dao.getById(id)?.let { projectFromDb(it) }

    fun addProject(project: Project) {
        dao.insert(
            projectToDb(project)
        )
    }

    fun deleteProject(id: Int) {
        dao.delete(id)
    }

    fun updateProject(project: Project) {
        dao.update(projectToDb(project))
    }
}