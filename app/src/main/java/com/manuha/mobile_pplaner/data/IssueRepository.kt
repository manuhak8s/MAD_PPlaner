package com.manuha.mobile_pplaner.data

import com.manuha.mobile_pplaner.App
import com.manuha.mobile_pplaner.data.database.IssueDao
import com.manuha.mobile_pplaner.data.database.issueFromDb
import com.manuha.mobile_pplaner.data.database.issueToDb
import com.manuha.mobile_pplaner.domain.model.Issue
import java.time.ZonedDateTime

val issueRepo = IssueRepository(App.database.issueDao())

class IssueRepository(private val dao: IssueDao,) {
    private val allIssues: List<Issue> = listOf(
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
    )

    fun getAllIssues(): List<Issue> = dao.getAll().mapNotNull { issueFromDb(it) }

    fun getIssueById(id: Int): Issue? = dao.getById(id)?.let { issueFromDb(it) }

    fun addIssue(issue: Issue) {
        dao.insert(
            issueToDb(issue)
        )
    }
}