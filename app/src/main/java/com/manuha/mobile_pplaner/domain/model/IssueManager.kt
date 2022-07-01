package com.manuha.mobile_pplaner.domain.model

/** unused code */
@JvmInline
value class IssueManagerId(val value: String)

class IssueManager(
    val id: IssueManagerId,
    val issues: Map<Issue, Int>,
    //val numberIssues: getIssuesMapSize(issues)
)

fun getIssuesMapSize (map: Map<Issue, Int>): Int {
    return map.size
}

fun addIssue(manager: IssueManager, issue: Issue): IssueManager {
    val issuesMap = manager.issues.toMutableMap()
    issuesMap[issue] = issue.id

    return IssueManager(
        manager.id,
        issuesMap
    )
}