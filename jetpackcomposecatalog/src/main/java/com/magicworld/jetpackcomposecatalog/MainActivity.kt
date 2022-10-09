package com.magicworld.jetpackcomposecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    /*var myText by remember { mutableStateOf("") }
                    MyTextField( myText ) {myText = it}*/
                    MyButtonExample()
                }
            }
        }
    }
}

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

@Composable
fun MyButtonExample() {

    var enabled by rememberSaveable { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Green,
                contentColor = Color.Red
            ),
            border = BorderStroke(5.dp, Color.Magenta)
        )
        {
            Text(text = "ADD")
        }
        OutlinedButton(
            onClick = { enabled = false },
            enabled = enabled,
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Green,
                contentColor = Color.Red,
                disabledBackgroundColor = Color.DarkGray,
                disabledContentColor = Color.Magenta
            )
        )
        {
            Text(text = "ADD")
        }
        TextButton(onClick = {}) {
            Text(text = "Click here")
        }
    }
}
@Composable
fun MyImage(){
    Image(painter = painterResource(R.drawable.ic_launcher_background ),
        contentDescription = "ejemplo",
        alpha = 0.5f )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyNewAppComposeTheme {
        MyImage()
    }
}