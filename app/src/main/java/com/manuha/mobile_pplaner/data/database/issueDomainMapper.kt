package com.manuha.mobile_pplaner.data.database

import com.manuha.mobile_pplaner.domain.model.Issue

fun issueToDb(issue:Issue): IssueDb = IssueDb(
    id = issue.id,
    title = issue.title,
    description = issue.description,
    level = issue.level,
    projectId = issue.projectId,
    created = issue.created,
    updated = issue.updated,
    deleted = issue.deleted,
    termination = issue.termination
)

fun issueFromDb(issue: IssueDb): Issue? {
    return Issue(
        id = issue.id,
        title = issue.title,
        description = issue.description,
        level = issue.level,
        projectId = issue.projectId,
        created = issue.created,
        updated = issue.updated,
        deleted = issue.deleted,
        termination = issue.termination
    )
}