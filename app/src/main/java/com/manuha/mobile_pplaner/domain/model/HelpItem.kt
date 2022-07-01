package com.manuha.mobile_pplaner.domain.model

/** static content items for help ui */
sealed class HelpItems {
    abstract val id: Int
    abstract val title: String
    abstract val text: String

    object Info : HelpItems() {
        override val id = 1
        override val title = "What is the Mobile PPlaner?"
        override val text = "This mobile application allows you to create projects with issues without any internet connection. That means that you can create and manage your project any time at any place with your Android device."
    }

    object HowToProjects : HelpItems() {
        override val id = 2
        override val title = "How to deal with Projects?"
        override val text = "Each Project represents a number of tasks that shall be done. At the main navigation you can find the Project Manager. This Tab contains actions to handle your projects. A project contains a title, description, list of issues/tasks and an end date."
    }

    object HowToIssues : HelpItems() {
        override val id = 3
        override val title = "How to deal with Issues?"
        override val text = "Issues are constructs that can be assign to a project. An Issue represents a task that shall be working on and contains a title, description, project dependency and an end date. At the Issue Manager Tab from the main navigation you can deal with issues, that means create, update and delete them."
    }

    object AppState : HelpItems() {
        override val id = 4
        override val title = "Future"
        override val text = "This mobile application is a mobile app development beta project from HFU University created by Manuel Haugg. After finishing the project no further features will be implemented."
    }
}