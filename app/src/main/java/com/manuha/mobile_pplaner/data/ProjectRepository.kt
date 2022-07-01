package com.manuha.mobile_pplaner.data

import com.manuha.mobile_pplaner.App
import com.manuha.mobile_pplaner.data.database.*
import com.manuha.mobile_pplaner.domain.model.Project

/** Project Repository Instance for using dao interface functions */
val projectRepo = ProjectRepository(App.database.projectDao())

/** ProjectRepository represents operations based on Projects by using the project dao interface */
class ProjectRepository(private val dao: ProjectDao,) {

    /** gets all projects from db */
    fun getAllProjects(): List<Project> = dao.getAll().mapNotNull { projectFromDb(it) }

    /** gets project from db by id */
    fun getProjectById(id: Int): Project? = dao.getById(id)?.let { projectFromDb(it) }

    /** adds a new project entry at db */
    fun addProject(project: Project) {
        dao.insert(
            projectToDb(project)
        )
    }

    /** removes a project entry at db */
    fun deleteProject(id: Int) {
        dao.delete(id)
    }

    /** updates a project entry at db */
    fun updateProject(project: Project) {
        dao.update(projectToDb(project))
    }
}