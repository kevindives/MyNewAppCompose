package com.magicworld.jetpackcomposecatalog

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.magicworld.jetpackcomposecatalog.ui.theme.MyNewAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNewAppComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //val myOptions = getOptions(titles = listOf("numero 1", "numero 2", "numero 3"))
                    /*Column {
                        myOptions.forEach { checkInfo ->
                            MyCheckBoxWithTextCompleted(checkInfo)
                        }

                    }*/
                    /*var myText by remember { mutableStateOf("") }
                    MyTextField( myText ) {myText = it}*/
                    /*var selected by rememberSaveable { mutableStateOf("kevin") }
                    MyRadioButtonList(selected){selected = it}*/
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        var show by rememberSaveable { mutableStateOf(false) }

                        Button(onClick = { show = true }) {
                            Text(text = "Mostar Dialogo")
                        }
                        MyDialog(
                            show = show,
                            onDismiss = { show = false },
                            onComfirm = { Log.i("kevin", "click") })
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyNewAppComposeTheme {
        MyDivider()
    }
}

@Composable
fun MyDropDowmMenu() {

    var selectedText by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val desserts = listOf("natilla", "helado", "cafe", "fruta")

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            desserts.forEach { dessert ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    selectedText = dessert
                }) {
                    Text(text = dessert)
                }
            }

        }
    }
}

@Composable
fun MyDivider() {

    Divider(
        Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 8.dp, end = 8.dp),
        color = Color.Blue,
        thickness = 1.dp
//        startIndent = 7.dp
    )
}

@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 16.dp,
        shape = MaterialTheme.shapes.small,
        backgroundColor = Color.Magenta,
        contentColor = Color.Yellow,
        border = BorderStroke(5.dp, Color.Green)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(text = "ejemplo 1")
            Text(text = "ejemplo 2")
            Text(text = "ejemplo 3")
        }
    }
}




