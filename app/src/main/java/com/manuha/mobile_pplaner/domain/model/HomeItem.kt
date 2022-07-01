package com.manuha.mobile_pplaner.domain.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

/** static content items for home ui */
sealed class HomeItems {
    abstract val id: Int
    abstract val title: String
    abstract val text: String
    abstract val icon: ImageVector
    abstract val iconDescription: String

    object Projects : HomeItems() {
        override val id = 1
        override val title = "Getting started with Projects"
        override val text = "You want to manage different projects with your mobile device? Then you have to try the Mobile PPlaner project manager. Just click the following icon at the bottom bar!"
        override val icon = Icons.Filled.Build
        override val iconDescription = "Projects"
    }

    object Issues : HomeItems() {
        override val id = 2
        override val title = "Getting started with Issues"
        override val text = "The right way to manage a project is creating tasks named by issues. Click the following icon at the bottom bar for managing your issues with Mobile PPlaner!"
        override val icon = Icons.Filled.Done
        override val iconDescription = "Issues"
    }

    object Help : HomeItems() {
        override val id = 3
        override val title = "You need help or other instructions?"
        override val text = "Then press the info icon at the bottom bar."
        override val icon = Icons.Filled.Info
        override val iconDescription = "Help"
    }

}