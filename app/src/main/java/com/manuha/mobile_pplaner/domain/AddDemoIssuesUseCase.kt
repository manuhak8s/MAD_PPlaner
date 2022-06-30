package com.manuha.mobile_pplaner.domain

import com.manuha.mobile_pplaner.data.IssueRepository
import com.manuha.mobile_pplaner.domain.model.Issue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.ZonedDateTime

class AddDemoIssuesUseCase (private val issueRepository: IssueRepository){
    suspend operator fun invoke() = withContext(Dispatchers.Default) {
        if (issueRepository.getAllIssues().isNotEmpty()) return@withContext

        listOfNotNull(
            Issue(
                id = 1,
                title = "test issue 1",
                description = "bla bla",
                level = 1,
                created = ZonedDateTime.now(),
                updated = ZonedDateTime.now(),
                deleted = ZonedDateTime.now(),
                termination = ZonedDateTime.now(),
                projectId = 2
            ),
            Issue(
                id = 2,
                title = "test issue 2",
                description = "bla bla bla bla",
                level = 3,
                created = ZonedDateTime.now(),
                updated = ZonedDateTime.now(),
                deleted = ZonedDateTime.now(),
                termination = ZonedDateTime.now(),
                projectId = 1
            ),
            Issue(
                id = 3,
                title = "test issue 3",
                description = "bla bla bla bla",
                level = 2,
                created = ZonedDateTime.now(),
                updated = ZonedDateTime.now(),
                deleted = ZonedDateTime.now(),
                termination = ZonedDateTime.now(),
                projectId = 1
            )
        ).forEach {
            issueRepository.addIssue(it)
        }
    }

}