package com.magicworld.jetpackcomposecatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Este es un ejemplo")
        Text(text = "Este es un ejemplo", fontWeight = FontWeight.Bold)
        Text(text = "Este es un ejemplo", color = Color.Blue)
        Text(text = "Este es un ejemplo", fontFamily = FontFamily.Cursive)
        Text(
            text = "Este es un ejemplo",
            textDecoration = TextDecoration.LineThrough
        )
        Text(
            text = "Este es un ejemplo",
            textDecoration = TextDecoration.Underline
        )
        Text(
            text = "Este es un ejemplo", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.LineThrough, TextDecoration.Underline)
                )
            )
        )
        Text(text = "Este es un ejemplo", fontSize = 30.sp)
    }

}

@Composable
fun MyTextField(name: String, onValueChanged: (String) -> Unit) {

    TextField(value = name, onValueChange = { onValueChanged(it) })
}

@Composable
fun MyTextFieldAdvance() {
    var myText by remember { mutableStateOf("") }
    TextField(
        value = myText,
        onValueChange = {
            myText = if (it.contains("a")) it.replace("a", "") else it
        },
        label = { Text(text = "Nombre") })
}

@Composable
fun MyTextFieldOutLined() {
    var myText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "Nombre") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Red,
            unfocusedBorderColor = Color.Blue
        )
    )
}