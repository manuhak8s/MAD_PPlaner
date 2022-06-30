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
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.manuha.mobile_pplaner.domain.model.demoIssues
import com.manuha.mobile_pplaner.domain.model.demoProjects
import java.util.*

@Composable
fun IssueScreen() {
    val issues = demoIssues
    val openCreateWindow = remember { mutableStateOf(false)  }

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
                            onClick = {

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
                            }
                            Row() {
                                val titleState = remember { mutableStateOf(TextFieldValue()) }
                                OutlinedTextField(
                                    value = titleState.value,
                                    onValueChange = {titleState.value = it},
                                    label = { Text("Description") },
                                    modifier = Modifier
                                        .padding(3.dp)
                                        .height(200.dp)
                                )
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

@Composable
fun showSelectProjectDropDown() {
    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var selectedOption by remember { mutableStateOf(demoProjects[0].title) }

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
                    demoProjects.forEach { project ->
                        DropdownMenuItem(onClick = {
                            Toast.makeText(context,project.title + " selected",Toast.LENGTH_SHORT).show()
                            selectedOption = project.title
                        }) {
                            Text(project.title)
                        }
                    }
                }
            }

            Row(Modifier) {
                Text(text = selectedOption, textAlign = TextAlign.Start)
            }
        }
    }
}

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
                }) {
                    Text(level)
                }
                Divider()
            }
        }

        Row(Modifier) {
            Text(text = selectedOption, textAlign = TextAlign.Start)
        }

    }
}

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

        // Creating a button that on
        // click displays/shows the DatePickerDialog
        Button(onClick = {
            datePickerDialog.show()
        }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58)) ) {
            Text(text = "Termination", color = Color.Black)
        }

        // Adding a space of 100dp height
        Spacer(modifier = Modifier.size(10.dp))

        // Displaying the mDate value in the Text
        Text(text = "${date.value}", textAlign = TextAlign.Start)
    }
}