package com.manuha.mobile_pplaner.domain

import com.manuha.mobile_pplaner.data.IssueRepository
import com.manuha.mobile_pplaner.data.ProjectRepository
import com.manuha.mobile_pplaner.domain.model.Issue
import com.manuha.mobile_pplaner.domain.model.Project
import com.manuha.mobile_pplaner.domain.model.demoIssues
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.ZonedDateTime

class AddDemoProjectsUseCase (private val projectRepository: ProjectRepository){
    suspend operator fun invoke() = withContext(Dispatchers.Default) {
        if (projectRepository.getAllProjects().isNotEmpty()) return@withContext

        listOfNotNull(
            Project(
                id = 1,
                title = "Kubernetes Platform Engineering",
                description = "This project includes all repositories for creating a cloud native Kubernetes infrastructure.",
                issues = demoIssues,
                created = ZonedDateTime.now(),
                updated = ZonedDateTime.now(),
                deleted = ZonedDateTime.now(),
                termination = "23.01.2025",
            ),
            Project(
                id = 2,
                title = "Mobile App Development",
                description = "A seminar hosted by Georg that results a prototype Android app.",
                issues = demoIssues,
                created = ZonedDateTime.now(),
                updated = ZonedDateTime.now(),
                deleted = ZonedDateTime.now(),
                termination = "01.07.2022",
            ),
            Project(
                id = 3,
                title = "API Server",
                description = "A full stack webapp needs an API server.",
                issues = demoIssues,
                created = ZonedDateTime.now(),
                updated = ZonedDateTime.now(),
                deleted = ZonedDateTime.now(),
                termination = "27.01.2023",
            )
        ).forEach {
            projectRepository.addProject(it)
        }
    }

}