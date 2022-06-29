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
import com.manuha.mobile_pplaner.domain.model.demoProjects

@Composable
fun ProjectScreen() {
    val projects = demoProjects

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        projects.forEach { project ->
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
                        project.title,
                        fontWeight = FontWeight.W900,
                        color = Color(0xFF4552B8)
                    )

                    Text(project.description)

                    Text (
                        "Open Tasks: ",
                        fontWeight = FontWeight.W900,
                        color = Color(0xFF000000)
                    )
                    project.issues.forEach { issue ->
                        Text("- " + issue.title)
                    }
                    Text("- " + "item")

                    Text("Termination: " + project.termination.toString())

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

