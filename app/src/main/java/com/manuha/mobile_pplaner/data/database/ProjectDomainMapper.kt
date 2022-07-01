package com.manuha.mobile_pplaner.data.database

import com.manuha.mobile_pplaner.domain.model.Project

/** maps a domain model project to a db project */
fun projectToDb(project: Project): ProjectDb = ProjectDb(
    id = project.id,
    title = project.title,
    description = project.description,
    issues = project.issues,
    created = project.created,
    updated = project.updated,
    deleted = project.deleted,
    termination = project.termination,
)

/** maps db project to a domain model project */
fun projectFromDb(project: ProjectDb): Project? {
    return Project(
        id = project.id,
        title = project.title,
        description = project.description,
        issues = project.issues,
        created = project.created,
        updated = project.updated,
        deleted = project.deleted,
        termination = project.termination
    )
}