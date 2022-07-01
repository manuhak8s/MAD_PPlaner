package com.manuha.mobile_pplaner.feature.home.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.manuha.mobile_pplaner.domain.model.HomeItems

/** home ui */
@Composable
fun HomeScreen() {
    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),) {
        listOf(
            HomeItems.Projects,
            HomeItems.Issues,
            HomeItems.Help
        ).forEach { homeItem ->
            Row {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                        .clickable { },
                    elevation = 10.dp
                ) {
                    Column (
                        modifier = Modifier.padding(15.dp)
                    ) {
                        Text (
                            homeItem.title,
                            fontWeight = FontWeight.W900,
                            color = Color(0xFF4552B8)
                        )
                        Text(homeItem.text)
                        Icon(homeItem.icon, homeItem.iconDescription)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreen_Preview() {
    HomeScreen()
}
