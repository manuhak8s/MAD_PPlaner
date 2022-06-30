package com.manuha.mobile_pplaner.data

import com.manuha.mobile_pplaner.App
import com.manuha.mobile_pplaner.data.database.IssueDao
import com.manuha.mobile_pplaner.data.database.issueFromDb
import com.manuha.mobile_pplaner.data.database.issueToDb
import com.manuha.mobile_pplaner.domain.model.Issue
import java.time.ZonedDateTime

val issueRepo = IssueRepository(App.database.issueDao())

class IssueRepository(private val dao: IssueDao,) {

    fun getAllIssues(): List<Issue> = dao.getAll().mapNotNull { issueFromDb(it) }

    fun getIssueById(id: Int): Issue? = dao.getById(id)?.let { issueFromDb(it) }

    fun addIssue(issue: Issue) {
        dao.insert(
            issueToDb(issue)
        )
    }

    fun deleteIssue(id: Int) {
        dao.delete(id)
    }

    fun updateIssue(issue: Issue) {
        dao.update(issueToDb(issue))
    }
}