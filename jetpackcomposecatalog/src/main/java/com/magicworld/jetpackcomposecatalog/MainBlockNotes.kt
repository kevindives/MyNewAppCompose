package com.magicworld.jetpackcomposecatalog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.magicworld.jetpackcomposecatalog.ui.theme.MyNewAppComposeTheme

@Composable
fun MyBlockNote() {
    var myText by remember { mutableStateOf("") }
    var myText1 by remember { mutableStateOf("") }
    Box(Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            TextField(
                value = myText,
                onValueChange = { myText = it },
                Modifier
                    .fillMaxWidth()
                    .weight(1f),
                label = { Text("Title") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,

                    )
            )
            TextField(
                value = myText1,
                onValueChange = { myText1 = it },
                Modifier
                    .fillMaxWidth()
                    .weight(9f),
                label = { Text("Note") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White

                )
            )
        }
    }
}
