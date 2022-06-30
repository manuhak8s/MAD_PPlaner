package com.manuha.mobile_pplaner.domain

import com.manuha.mobile_pplaner.data.issueRepo
import com.manuha.mobile_pplaner.domain.model.Issue

class DeleteIssueUseCase {
    fun deleteIssue (id: Int): Boolean{
        issueRepo.deleteIssue(id)
        return true
    }
}