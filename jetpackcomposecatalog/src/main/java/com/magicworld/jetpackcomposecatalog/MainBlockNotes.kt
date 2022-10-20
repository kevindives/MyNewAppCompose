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
                placeholder = { Text("Title") },
                maxLines = 1,
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    placeholderColor= Color(0xFFB2B2B2),
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,

                    )
            )
            TextField(
                value = myText1,
                onValueChange = { myText1 = it },
                Modifier
                    .fillMaxWidth()
                    .weight(9f),
                placeholder = { Text("Note") },
                colors = TextFieldDefaults.textFieldColors(
                    placeholderColor= Color(0xFFB2B2B2),
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White

                )
            )
        }
    }
}
