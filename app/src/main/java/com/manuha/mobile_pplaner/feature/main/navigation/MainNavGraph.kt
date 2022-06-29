package com.manuha.mobile_pplaner.feature.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.manuha.mobile_pplaner.feature.home.ui.HomeScreen
import com.manuha.mobile_pplaner.feature.issue.ui.HelpScreen
import com.manuha.mobile_pplaner.feature.issue.ui.IssueScreen
import com.manuha.mobile_pplaner.feature.issue.ui.ProjectScreen
import com.manuha.mobile_pplaner.feature.login.ui.LoginScreen
import com.manuha.mobile_pplaner.feature.main.ui.MainScreen

@Composable
fun MainNavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = NavBarItem.Home.routeName) {
        composable(NavBarItem.Home.routeName) {
            HomeScreen()
        }
        composable(NavBarItem.Projects.routeName) {
            ProjectScreen()
        }
        composable(NavBarItem.Issues.routeName) {
            IssueScreen()
        }
        composable(NavBarItem.Help.routeName) {
            HelpScreen()
        }
        composable(NavBarItem.Login.routeName) {
            LoginScreen()
        }

    }
}