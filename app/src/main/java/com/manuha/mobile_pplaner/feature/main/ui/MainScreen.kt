package com.manuha.mobile_pplaner.feature.main.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.manuha.mobile_pplaner.feature.main.navigation.MainNav

@Composable
fun MainScreen() {
    MainScreenUI()
}

@Composable
private fun MainScreenUI() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Hello world!")
                },
                actions = {
                    MainNav(navController)
                }
            )
        },
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Card {
                Text("Moini")
            }
        }
    }
}

@Composable
@Preview
fun MainScreen_Preview() {
    MainScreenUI()
}