package com.manuha.mobile_pplaner.domain

import com.manuha.mobile_pplaner.data.projectRepo
import com.manuha.mobile_pplaner.domain.model.Project

/** use case fore creating a project */
class CreateProjectUseCase {
    fun createProject (project: Project): Boolean{
        projectRepo.addProject(project)
        return true
    }
}