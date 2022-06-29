package com.manuha.mobile_pplaner.feature.main.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.manuha.mobile_pplaner.feature.main.ui.MainScreen

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