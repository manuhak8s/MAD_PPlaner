package com.manuha.mobile_pplaner.feature.main.navigation

import com.manuha.mobile_pplaner.R

sealed class NavBarItem {
    abstract val routeName: String
   // abstract val title: Int
    //abstract val icon: Int

    object Home : NavBarItem() {
        override val routeName = "home"
        //override val title = R.string.home_title_navigation
        //override val icon = R.drawable.ic_launcher_foreground
    }

    /*object Projects : NavBarItem() {
        override val routeName = "projects"
        override val title = "Projects"
        //override val icon = R.drawable.ic_launcher_foreground
    }

    object Issues : NavBarItem() {
        override val routeName = "issues"
        override val title = "Issues"
        //override val icon = R.drawable.ic_launcher_foreground
    }

    object Help : NavBarItem() {
        override val routeName = "help"
        override val title = "Help"
        //override val icon = R.drawable.ic_launcher_foreground
    }*/
}