package com.manuha.mobile_pplaner.domain

import com.manuha.mobile_pplaner.data.projectRepo

/** use case for deleting a project */
class DeleteProjectUseCase {
    fun deleteProject (id: Int): Boolean{
        projectRepo.deleteProject(id)
        return true
    }
}