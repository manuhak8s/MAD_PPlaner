package com.manuha.mobile_pplaner.domain

import com.manuha.mobile_pplaner.data.issueRepo

/** use case for deleting an issue */
class DeleteIssueUseCase {
    fun deleteIssue (id: Int): Boolean{
        issueRepo.deleteIssue(id)
        return true
    }
}