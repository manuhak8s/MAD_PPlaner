package com.manuha.mobile_pplaner.feature.help.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.manuha.mobile_pplaner.domain.model.HelpItems

@Composable
fun HelpScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        listOf(
            HelpItems.Info,
            HelpItems.HowToProjects,
            HelpItems.HowToIssues,
            HelpItems.AppState
        ).forEach { homeItem ->
            Row {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
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
                    }
                }
            }
        }
    }
}

