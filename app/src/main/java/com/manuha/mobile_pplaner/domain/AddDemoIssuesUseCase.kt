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
                title = "Project Structure Initialization",
                description = "For further actions the mobile app development project has to be set up based on an Android Studio project.",
                level = 1,
                created = ZonedDateTime.now(),
                updated = ZonedDateTime.now(),
                deleted = ZonedDateTime.now(),
                termination = "30.09.2022",
                projectId = "Mobile App Development"
            ),
            Issue(
                id = 2,
                title = "Data Base Binding",
                description = "Android Room has to be configured and implemented for saving data persistent.",
                level = 3,
                created = ZonedDateTime.now(),
                updated = ZonedDateTime.now(),
                deleted = ZonedDateTime.now(),
                termination = "22.10.2022",
                projectId = "Mobile App Development"
            ),
            Issue(
                id = 3,
                title = "Implement CI/CD Tekton Pipeline",
                description = "The Kubernetes env needs a continous integration of all Bitbucket repositories.",
                level = 2,
                created = ZonedDateTime.now(),
                updated = ZonedDateTime.now(),
                deleted = ZonedDateTime.now(),
                termination = "09.09.2022",
                projectId = "Kubernetes Platform Engineering"
            ),
            Issue(
                id = 4,
                title = "API Server",
                description = "Our central service needs APIs for handling incoming requests of the clients.",
                level = 1,
                created = ZonedDateTime.now(),
                updated = ZonedDateTime.now(),
                deleted = ZonedDateTime.now(),
                termination = "20.12.2022",
                projectId = "Central Service App"
            )
        ).forEach {
            issueRepository.addIssue(it)
        }
    }

}