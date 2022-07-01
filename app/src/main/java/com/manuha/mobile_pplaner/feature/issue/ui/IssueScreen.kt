package com.manuha.mobile_pplaner.feature.issue.ui

import android.app.DatePickerDialog
import android.widget.DatePicker
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
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.manuha.mobile_pplaner.domain.CreateIssueUseCase
import com.manuha.mobile_pplaner.domain.DeleteIssueUseCase
import com.manuha.mobile_pplaner.domain.GetIssuesUseCase
import com.manuha.mobile_pplaner.domain.GetProjectsUseCase
import com.manuha.mobile_pplaner.domain.model.Issue
import java.time.ZonedDateTime
import java.util.*

/** creation helper vars */
var creationId =  (0..9999999).random()
var creationTitle = ""
var creationDescription = ""
var creationLevel = 0
var creationProjectId = ""
var creationCreated = ZonedDateTime.now()
var creationUpdated = ZonedDateTime.now()
var creationDeleted = ZonedDateTime.now()
var creationTermination = ""

/** update helper vars */
var updatingId =  0
var updatingTitle = ""
var updatingDescription = ""
var updatingLevel = 0
var updatingProjectId = ""
var updatingCreated = ZonedDateTime.now()
var updatingUpdated = ZonedDateTime.now()
var updatingDeleted = ZonedDateTime.now()
var updatingTermination = ""

/** issue ui */
@Composable
fun IssueScreen() {
    //val issues = demoIssues
    val issues = GetIssuesUseCase().allIssues()
    val openCreateWindow = remember { mutableStateOf(false)  }
    val openUpdateWindow = remember { mutableStateOf(false)  }
    val context = LocalContext.current

    /** update instance (beta - not used) */
    var issueUpdate = Issue (
        id = updatingId,
        title = updatingTitle,
        description = updatingDescription,
        level = updatingLevel,
        projectId =  updatingProjectId,
        created = updatingCreated,
        updated = updatingUpdated,
        deleted =  updatingDeleted ,
        termination = updatingTermination
    )

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

                    Text("Termination: " + issue.termination)

                    Row {
                        /** edit issue button */
                        OutlinedButton(
                            onClick = {
                                openUpdateWindow.value = true
                                val issueUpdate = Issue(
                                    id = issue.id,
                                    title = issue.title,
                                    description = issue.description,
                                    level = issue.level,
                                    projectId = issue.projectId,
                                    created = issue.created,
                                    updated = issue.updated,
                                    deleted = issue.deleted,
                                    termination = issue.termination
                                )
                            },
                            border = BorderStroke(1.dp, Color.DarkGray),
                            shape = CircleShape,
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.DarkGray),
                        ) {
                            Icon(Icons.Filled.Edit, "EditBtn")
                        }
                        /** delete issue button */
                        OutlinedButton(
                            onClick = {
                                DeleteIssueUseCase().deleteIssue(issue.id)
                                Toast.makeText(context, "${issue.title} deleted",Toast.LENGTH_SHORT).show()
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

        /** create issue button */
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

        /** create issue dialog window */
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
                        Text(text = "Create Issue")
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
                            }
                            Row() {
                                Column(Modifier.padding(horizontal = 25.dp)) {
                                    showSelectLevelDropDown()
                                }
                                Column (){
                                    showSelectProjectDropDown()
                                }
                            }
                        }
                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                openCreateWindow.value = false
                                val issueCreate = Issue(
                                    id = creationId,
                                    title = creationTitle,
                                    description = creationDescription,
                                    level = creationLevel,
                                    projectId = creationProjectId,
                                    created = creationCreated,
                                    updated = creationUpdated,
                                    deleted = creationDeleted,
                                    termination = creationTermination
                                )
                                CreateIssueUseCase().createIssue(issueCreate)
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

        /** update issue dialog window */
        Column {

            if (openUpdateWindow.value) {

                AlertDialog(
                    modifier = Modifier.fillMaxHeight(),
                    onDismissRequest = {
                        // Dismiss the dialog when the user clicks outside the dialog or on the back
                        // button. If you want to disable that functionality, simply use an empty
                        // onCloseRequest.
                        openCreateWindow.value = false
                    },
                    title = {
                        Text(text = "Update Issue")
                    },
                    text = {
                        Column() {
                            Row() {
                                val titleState = remember { mutableStateOf(TextFieldValue()) }
                                OutlinedTextField(
                                    value =  titleState.value,
                                    onValueChange = {titleState.value = titleState.value},
                                    label = { Text("Title") },
                                    modifier = Modifier.padding(3.dp),
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
                            }
                            Row() {
                                Column(Modifier.padding(horizontal = 25.dp)) {
                                    showSelectLevelDropDown()
                                }
                                Column (){
                                    showSelectProjectDropDown()
                                }
                            }
                        }
                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                openUpdateWindow.value = false
                                /*val issue = Issue(
                                    id = creationId,
                                    title = creationTitle,
                                    description = creationDescription,
                                    level = creationLevel,
                                    projectId = creationProjectId,
                                    created = creationCreated,
                                    updated = creationUpdated,
                                    deleted = creationDeleted,
                                    termination = creationTermination
                                )
                                CreateIssueUseCase().createIssue(issue)*/
                            }) {
                            Text("update")
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = {
                                openUpdateWindow.value = false
                            }) {
                            Text("decline")
                        }
                    }
                )
            }
        }
    }
}

/** calcIssueCardColor calculates the color of an issue card by its level */
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

/** showSelectProjectDropDown displays a drop down menu */
@Composable
fun showSelectProjectDropDown() {
    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var projects = GetProjectsUseCase().allProjects()
    var selectedOption by remember { mutableStateOf(projects[0].title) }

    Column() {
        Box(modifier = Modifier
            .wrapContentSize(Alignment.TopStart)) {
            IconButton(onClick = { expanded = true }) {
                Column() {
                    Row() {
                        Text(text = "Select Project")
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "Select")
                    }
                }
            }

            Row() {
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    projects.forEach { project ->
                        DropdownMenuItem(onClick = {
                            Toast.makeText(context,project.title + " selected",Toast.LENGTH_SHORT).show()
                            selectedOption = project.title
                            expanded = false
                        }) {
                            Text(project.title)
                        }
                    }
                }
            }

            Row(Modifier) {
                Text(text = selectedOption, textAlign = TextAlign.Start)
                creationProjectId = selectedOption
            }
        }
    }
}

/** showSelectLevelDropDown displays a drop down menu */
@Composable
fun showSelectLevelDropDown() {
    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val levelOptions = listOf<String>("easy", "medium", "hard")
    var selectedOption by remember { mutableStateOf(levelOptions[0]) }

    Box(modifier = Modifier
        .wrapContentSize(Alignment.TopStart)) {
        IconButton(onClick = { expanded = true }) {
            Column() {
                Row() {
                    Text(text = "Select Level")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Select")
                }
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            levelOptions.forEach { level ->
                DropdownMenuItem(onClick = {
                    Toast.makeText(context, "level $level selected",Toast.LENGTH_SHORT).show()
                    selectedOption = level
                    expanded = false
                }) {
                    Text(level)
                }
                Divider()
            }
        }

        Row(Modifier) {
            Text(text = selectedOption, textAlign = TextAlign.Start)
            creationLevel = calcIntLevel(selectedOption)
        }

    }
}

/** calcIntLevel calculates the number value of a level */
fun calcIntLevel(level: String): Int {
    if (level=="easy") {
        return 1
    }
    if (level=="medium") {
        return 2
    }
    if (level=="hard") {
        return 3
    }

    return 0
}

/** TriggerDatePicker displays a calendar for selecting a date */
@Composable
fun TriggerDatePicker() {
    val context = LocalContext.current
    val year: Int
    val month: Int
    val day: Int
    val calendar = Calendar.getInstance()

    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val date = remember { mutableStateOf("") }

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            date.value = "$mDayOfMonth/${mMonth+1}/$mYear"
        }, year, month, day
    )

    Column() {
        Button(onClick = {
            datePickerDialog.show()
        }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58)) ) {
            Text(text = "Termination", color = Color.Black)
        }

        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "${date.value}", textAlign = TextAlign.Start)
        creationTermination = date.value
    }
}