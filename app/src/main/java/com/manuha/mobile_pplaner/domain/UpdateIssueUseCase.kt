package com.manuha.mobile_pplaner.domain

import com.manuha.mobile_pplaner.data.issueRepo
import com.manuha.mobile_pplaner.domain.model.Issue

/** use case for updating an issue (beta -  not used) */
class UpdateIssueUseCase {
    fun updateIssue (issue: Issue): Boolean{
        issueRepo.updateIssue(issue)
        return true
    }
}