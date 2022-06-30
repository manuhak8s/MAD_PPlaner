package com.manuha.mobile_pplaner.feature.issue.ui

import android.widget.Toast
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
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.manuha.mobile_pplaner.domain.*
import com.manuha.mobile_pplaner.domain.model.Issue
import com.manuha.mobile_pplaner.domain.model.Project
import com.manuha.mobile_pplaner.domain.model.demoIssues
import com.manuha.mobile_pplaner.domain.model.demoProjects

@Composable
fun ProjectScreen() {
    //val projects = demoProjects
    val projects = GetProjectsUseCase().allProjects()
    val openCreateWindow = remember { mutableStateOf(false)  }
    val openUpdateWindow = remember { mutableStateOf(false)  }
    val context = LocalContext.current

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

                    Text("Termination: " + project.termination.toString())

                    Row {
                        OutlinedButton(
                            onClick = {
                                openUpdateWindow.value = true
                            },
                            border = BorderStroke(1.dp, Color.DarkGray),
                            shape = CircleShape,
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.DarkGray),
                        ) {
                            Icon(Icons.Filled.Edit, "EditBtn")
                        }

                        OutlinedButton(
                            onClick = {
                                DeleteProjectUseCase().deleteProject(project.id)
                                Toast.makeText(context, "${project.title} deleted",Toast.LENGTH_SHORT).show()
                            },
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
            onClick = {
                openCreateWindow.value = true
            },
            border = BorderStroke(1.dp, Color.DarkGray),
            shape = RoundedCornerShape(100),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.DarkGray)
        ) {
            Icon(Icons.Filled.Add, "AddBtn")
        }

        // create dialog
        Column {

            if (openCreateWindow.value) {

                AlertDialog(
                    modifier = Modifier.fillMaxHeight(),
                    onDismissRequest = {
                        // Dismiss the dialog when the user clicks outside the dialog or on the back
                        // button. If you want to disable that functionality, simply use an empty
                        // onCloseRequest.
                        openCreateWindow.value = false
                    },
                    title = {
                        Text(text = "Create Project")
                    },
                    text = {
                        Column() {
                            Row() {
                                val titleState = remember { mutableStateOf(TextFieldValue()) }
                                OutlinedTextField(
                                    value = titleState.value,
                                    onValueChange = {titleState.value = it},
                                    label = { Text("Title") },
                                    modifier = Modifier.padding(3.dp)
                                )
                                creationTitle = titleState.value.text
                            }
                            Row() {
                                val descriptionState = remember { mutableStateOf(TextFieldValue()) }
                                OutlinedTextField(
                                    value = descriptionState.value,
                                    onValueChange = {descriptionState.value = it},
                                    label = { Text("Description") },
                                    modifier = Modifier
                                        .padding(3.dp)
                                        .height(200.dp)
                                )
                                creationDescription = descriptionState.value.text
                            }
                            Row() {
                                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(end = 20.dp)) {
                                    TriggerDatePicker()
                                }
                                Column() {
                                    showSelectIssuesDropDown()
                                }
                            }
                        }
                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                openCreateWindow.value = false
                                val projectCreate = Project(
                                    id = creationId,
                                    title = creationTitle,
                                    description = creationDescription,
                                    issues = demoIssues,
                                    created = creationCreated,
                                    updated = creationUpdated,
                                    deleted = creationDeleted,
                                    termination = creationTermination
                                )
                                CreateProjectUseCase().createProject(projectCreate)
                                Toast.makeText(context, "$creationTitle created",Toast.LENGTH_SHORT).show()
                            }) {
                            Text("create")
                        }
                    },
                    dismissButton = {
                        Button(

                            onClick = {
                                openCreateWindow.value = false
                            }) {
                            Text("decline")
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun showSelectIssuesDropDown() {
    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val issues = GetIssuesUseCase().allIssues()
    var selectedOption by remember { mutableStateOf(issues[0].title) }

    Box(modifier = Modifier
        .wrapContentSize(Alignment.TopStart)) {
        IconButton(onClick = { expanded = true }) {
            Column() {
                Row() {
                    Text(text = "Select Issues")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Select")
                }
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            issues.forEach { issue ->
                DropdownMenuItem(onClick = {
                    Toast.makeText(context, "issue $issue selected", Toast.LENGTH_SHORT).show()
                    selectedOption = issue.title
                    expanded = false
                }) {
                    Text(issue.title)
                }
                Divider()
            }
        }
    }
}

