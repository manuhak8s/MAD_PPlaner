package com.manuha.mobile_pplaner.data

import com.manuha.mobile_pplaner.App
import com.manuha.mobile_pplaner.data.database.IssueDao
import com.manuha.mobile_pplaner.data.database.issueFromDb
import com.manuha.mobile_pplaner.data.database.issueToDb
import com.manuha.mobile_pplaner.domain.model.Issue

/** Issue Repository Instance for using dao interface functions */
val issueRepo = IssueRepository(App.database.issueDao())

/** IssueRepository represents operations based on Issues by using the issue dao interface */
class IssueRepository(private val dao: IssueDao,) {

    /** gets all issues from db */
    fun getAllIssues(): List<Issue> = dao.getAll().mapNotNull { issueFromDb(it) }

    /** gets issue from db by id */
    fun getIssueById(id: Int): Issue? = dao.getById(id)?.let { issueFromDb(it) }

    /** adds a new issue entry at db */
    fun addIssue(issue: Issue) {
        dao.insert(
            issueToDb(issue)
        )
    }

    /** removes a issue entry at db */
    fun deleteIssue(id: Int) {
        dao.delete(id)
    }

    /** updates a issue entry at db */
    fun updateIssue(issue: Issue) {
        dao.update(issueToDb(issue))
    }
}