package com.manuha.mobile_pplaner.domain

import com.manuha.mobile_pplaner.data.issueRepo
import com.manuha.mobile_pplaner.domain.model.Issue

/** use case fore creating an issue */
class CreateIssueUseCase {
    fun createIssue (issue: Issue): Boolean{
        issueRepo.addIssue(issue)
        return true
    }
}