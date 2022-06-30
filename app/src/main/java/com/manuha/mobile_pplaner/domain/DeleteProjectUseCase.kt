package com.manuha.mobile_pplaner.domain

import com.manuha.mobile_pplaner.data.issueRepo
import com.manuha.mobile_pplaner.data.projectRepo

class DeleteProjectUseCase {
    fun deleteProject (id: Int): Boolean{
        projectRepo.deleteProject(id)
        return true
    }
}