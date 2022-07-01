package com.manuha.mobile_pplaner.domain

import com.manuha.mobile_pplaner.data.projectRepo
import com.manuha.mobile_pplaner.domain.model.Project

/** use case for getting all projects */
class GetProjectsUseCase {
    fun allProjects (): List<Project>{
        return projectRepo.getAllProjects()
    }
}