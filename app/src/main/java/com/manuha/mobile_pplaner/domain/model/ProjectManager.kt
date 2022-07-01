package com.manuha.mobile_pplaner.domain.model

/** unused code */
@JvmInline
value class ProjectManagerId(val value: String)

class ProjectManager(
    val id: ProjectManagerId,
    val projects: Map<Project, Int>,
    //val numberIssues: getIssuesMapSize(issues)
)

fun addProject(manager: ProjectManager, project: Project): ProjectManager {
    val projectMap = manager.projects.toMutableMap()
    projectMap[project] = project.id

    return ProjectManager(
        manager.id,
        projectMap
    )
}