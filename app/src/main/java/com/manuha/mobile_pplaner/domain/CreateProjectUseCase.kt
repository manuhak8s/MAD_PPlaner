package com.manuha.mobile_pplaner.domain

import com.manuha.mobile_pplaner.data.issueRepo
import com.manuha.mobile_pplaner.data.projectRepo
import com.manuha.mobile_pplaner.domain.model.Issue
import com.manuha.mobile_pplaner.domain.model.Project

class CreateProjectUseCase {
    fun createProject (project: Project): Boolean{
        projectRepo.addProject(project)
        return true
    }
}