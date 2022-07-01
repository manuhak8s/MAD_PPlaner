package com.manuha.mobile_pplaner.feature.main.navigation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

/** bottom main navigation */
@Composable
fun MainNav(navController: NavController) {
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        listOf(
            NavBarItem.Home,
            NavBarItem.Projects,
            NavBarItem.Issues,
            NavBarItem.Help
        ).forEach { navItem ->
            BottomNavigationItem(
                selected = currentRoute == navItem.routeName,
                icon = {
                    CalcIcon(navItem.routeName)
                },
                onClick = {
                    navController.navigate(navItem.routeName) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}

/** CalcIcon calculates based on a route its matching icon */
@Composable
fun CalcIcon(routeName: String) {
    if (routeName == "home") {
        Icon(Icons.Filled.Home, "Home")
    }
    if (routeName == "projects") {
        Icon(Icons.Filled.Build, "Projects")
    }
    if (routeName == "issues") {
        Icon(Icons.Filled.Done, "Issues")
    }
    if (routeName == "help") {
        Icon(Icons.Filled.Info, "Help")
    }
}