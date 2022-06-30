package com.manuha.mobile_pplaner.domain

import com.manuha.mobile_pplaner.data.issueRepo
import com.manuha.mobile_pplaner.domain.model.Issue

class UpdateIssueUseCase {
    fun updateIssue (issue: Issue): Boolean{
        issueRepo.updateIssue(issue)
        return true
    }
}