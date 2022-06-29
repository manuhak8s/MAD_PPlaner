package com.manuha.mobile_pplaner.feature.issue.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.manuha.mobile_pplaner.domain.model.demoIssues
import com.manuha.mobile_pplaner.domain.model.demoProjects

@Composable
fun IssueScreen() {
    val issues = demoIssues

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        issues.forEach { issue ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .clickable { },
                elevation = 10.dp,
                backgroundColor = calcIssueCardColor(issue.level)
            ) {
                Column (
                    modifier = Modifier.padding(15.dp)
                ) {
                    Text (
                        issue.title,
                        fontWeight = FontWeight.W900,
                        color = Color(0xFF4552B8)
                    )

                    Text (
                        issue.projectId.toString(),
                        fontWeight = FontWeight.W900,
                        color = Color(0xFF4552B8)
                    )

                    Text(issue.description)

                    Text("Termination: " + issue.termination.toString())

                    Row {
                        OutlinedButton(
                            onClick = { /*TODO*/ },
                            border = BorderStroke(1.dp, Color.DarkGray),
                            shape = CircleShape,
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.DarkGray),
                        ) {
                            Icon(Icons.Filled.Edit, "EditBtn")
                        }

                        OutlinedButton(
                            onClick = { /*TODO*/ },
                            border = BorderStroke(1.dp, Color.Red),
                            shape = CircleShape,
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
                        ) {
                            Icon(Icons.Filled.Delete, "DeleteBtn")
                        }
                    }
                }
            }
        }

        OutlinedButton(
            onClick = { /*TODO*/ },
            border = BorderStroke(1.dp, Color.DarkGray),
            shape = RoundedCornerShape(100),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.DarkGray)
        ) {
            Icon(Icons.Filled.Add, "AddBtn")
        }
    }
}

fun calcIssueCardColor(level: Int): Color {
    if (level == 1) {
        return Color(0xFF468b00)
    }
    if (level == 2) {
        return Color(0xFFCF9979)
    }
    if (level == 3) {
        return Color(0xFFCF6679)
    }

    return Color.White
}