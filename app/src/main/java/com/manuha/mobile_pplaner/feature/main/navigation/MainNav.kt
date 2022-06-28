package com.manuha.mobile_pplaner.feature.main.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.manuha.mobile_pplaner.feature.main.ui.MainScreen

@Composable
fun MainNav(navController: NavController) {
    val expanded = remember { mutableStateOf(false) } // 1
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Box(
        Modifier
            .wrapContentSize(Alignment.TopEnd)
    ) {
        IconButton(onClick = {
            expanded.value = true // 2
        }) {
            Icon(
                Icons.Filled.Menu,
                contentDescription = "Main Menu"
            )
        }
    }

    DropdownMenu(
        expanded = expanded.value,
        onDismissRequest = { expanded.value = false },
    )
    {
        /*listOf(
            NavBarItem.Home,
            //NavBarItem.Projects,
            //NavBarItem.Issues,
            //NavBarItem.Help
        ).forEach { navItem ->
            DropdownMenuItem(onClick = {
                expanded.value = false
                navController.navigate(navItem.routeName) {
                    navController.graph.startDestinationRoute?.let { screen_route ->
                        popUpTo(screen_route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }) {

            }
        }*/
        DropdownMenuItem(onClick = {
            expanded.value = false // 3

        }) {
            Text("First item")
        }

        Divider()

        DropdownMenuItem(onClick = {
            expanded.value = false
            //bodyContent.value = "Second Item Selected"
        }) {
            Text("Second item")
        }

        Divider()

        DropdownMenuItem(onClick = {
            expanded.value = false
            //bodyContent.value = "Third Item Selected"
        }) {
            Text("Third item")
        }

        Divider()

        DropdownMenuItem(onClick = {
            expanded.value = false
            //bodyContent.value = "Fourth Item Selected"
        }) {
            Text("Fourth item")
        }
    }
}