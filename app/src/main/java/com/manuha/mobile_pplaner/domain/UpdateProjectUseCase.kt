package com.manuha.mobile_pplaner.domain

import com.manuha.mobile_pplaner.data.projectRepo
import com.manuha.mobile_pplaner.domain.model.Project

/** use case for updating a project (beta -  not used) */
class UpdateProjectUseCase {
    fun updateProject (project: Project): Boolean{
        projectRepo.updateProject(project)
        return true
    }
}