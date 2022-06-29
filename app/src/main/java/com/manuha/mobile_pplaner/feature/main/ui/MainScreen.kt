package com.manuha.mobile_pplaner.feature.main.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.manuha.mobile_pplaner.feature.main.navigation.MainNav
import com.manuha.mobile_pplaner.feature.main.navigation.MainNavigationGraph

@Composable
fun MainScreen() {
    MainScreenUI()
}

@Composable
private fun MainScreenUI() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            
            TopAppBar(
                title = {
                    Text("Hello from PPLaner!")
                },
            )
        },
        bottomBar = { MainNav(navController = navController)}
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            MainNavigationGraph(navController = navController)
        }
    }
}

@Composable
@Preview
fun MainScreen_Preview() {
    MainScreenUI()
}