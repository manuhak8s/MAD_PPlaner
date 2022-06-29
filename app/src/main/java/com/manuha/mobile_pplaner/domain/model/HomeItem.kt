package com.manuha.mobile_pplaner.domain.model

import android.graphics.drawable.Icon
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import com.manuha.mobile_pplaner.feature.main.navigation.NavBarItem

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

/*
data class HomeItem(
    val id: Int,
    val title: String,
    val text: String,
    val icon: ImageVector,
    val iconDescription: String
)

val homeItems = listOf<HomeItem>(
    HomeItem(
      id = 1,
        title = "Getting started with Projects",
        text = "You want to manage different projects with your mobile device? Then you have to try the Mobile PPlaner project manager. Just click the following icon at the bottom bar!",
        icon = Icons.Filled.Build,
         iconDescription = "Projects"
    ),
    HomeItem(
        id = 2,
        title = "Getting started with Issues",
        text = "The right way to manage a project is creating tasks named by issues. Click the following icon at the bottom bar for managing your issues with Mobile PPlaner!",
        icon = Icons.Filled.Done,
        iconDescription = "Issues"
    ),
    HomeItem(
        id = 3,
        title = "You need help or other instructions?",
        text = "Then press the info icon at the bottom bar.",
        icon = Icons.Filled.Info,
        iconDescription = "Help"
    ),
)*/