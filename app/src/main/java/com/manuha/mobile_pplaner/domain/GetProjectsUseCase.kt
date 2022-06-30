package com.manuha.mobile_pplaner.domain

import com.manuha.mobile_pplaner.data.issueRepo
import com.manuha.mobile_pplaner.data.projectRepo
import com.manuha.mobile_pplaner.domain.model.Issue
import com.manuha.mobile_pplaner.domain.model.Project

class GetProjectsUseCase {
    fun allProjects (): List<Project>{
        return projectRepo.getAllProjects()
    }
}