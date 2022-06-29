package com.manuha.mobile_pplaner.feature.main.navigation

import android.graphics.drawable.Icon
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import com.manuha.mobile_pplaner.R

sealed class NavBarItem {
    abstract val routeName: String
    //abstract val title: Int
    //abstract val icon: Icon

    object Home : NavBarItem() {
        override val routeName = "home"
        //override val title = R.string.home_title_navigation
        //override val icon = HomeIcon()
    }

    object Projects : NavBarItem() {
        override val routeName = "projects"
        //override val title = "Projects"
        //override val icon = R.drawable.ic_launcher_foreground
    }

    object Issues : NavBarItem() {
        override val routeName = "issues"
        //override val title = "Issues"
        //override val icon = R.drawable.ic_launcher_foreground
    }

    object Help : NavBarItem() {
        override val routeName = "help"
        //override val title = "Help"
        //override val icon = R.drawable.ic_launcher_foreground
    }

    object Login : NavBarItem() {
        override val routeName = "login"
        //override val title = "Help"
        //override val icon = R.drawable.ic_launcher_foreground
    }
}