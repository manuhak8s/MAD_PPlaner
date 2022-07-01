package com.manuha.mobile_pplaner.domain

import com.manuha.mobile_pplaner.data.issueRepo
import com.manuha.mobile_pplaner.domain.model.Issue

/** use case for getting all issues */
class GetIssuesUseCase {
    fun allIssues (): List<Issue>{
        return issueRepo.getAllIssues()
    }
}