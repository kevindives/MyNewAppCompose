package com.magicworld.jetpackcomposecatalog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.magicworld.jetpackcomposecatalog.ui.theme.MyNewAppComposeTheme
import com.magicworld.jetpackcomposecatalog.ui.theme.Shapes

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
fun MyIconButton() {
    IconButton(onClick = { /*TODO*/ }) {
        Column(
            modifier = Modifier
                .fillMaxSize().padding(12.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "",
                tint = Color.Red,
                modifier = Modifier.background(Color.Blue, shape = CutCornerShape(5.dp)).padding(12.dp).scale(2f , 2f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    MyNewAppComposeTheme {
        MyIconButton()
    }
}
