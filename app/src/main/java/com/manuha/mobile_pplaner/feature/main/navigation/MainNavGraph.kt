package com.manuha.mobile_pplaner.feature.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.manuha.mobile_pplaner.feature.main.ui.MainScreen

@Composable
fun MainNavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = NavBarItem.Home.routeName) {
        composable(NavBarItem.Home.routeName) {
            MainScreen()
        }
        /*composable(NavBarItem.Projects.routeName) {
            //ProjectScreen()
        }
        composable(NavBarItem.Issues.routeName) {
            //IssuesScreen()
        }
        composable(NavBarItem.Help.routeName) {
            //Help()
        }*/
    }
}