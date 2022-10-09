package com.magicworld.mynewappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.magicworld.mynewappcompose.ui.theme.MyNewAppComposeTheme

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
                    MyStateExample()
                }
            }
        }
    }
}

@Composable
fun MyStateExample() {

    var counter by rememberSaveable { mutableStateOf(0) }

    Column(Modifier.fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter ++ }) {
            Text(text = "pulsar")
        }
        Text(text = "he sido pulsado $counter veces")

    }

}


@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan), Alignment.Center
        ) {
            Text("Ejemplo 1")
        }
        MySpacer(size = 30)
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Magenta), Alignment.Center
            ) {
                Text("Ejemplo 2")
            }
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Blue), Alignment.Center
            ) {
                Text("hola android")
            }
        }
        MySpacer(size = 60)
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Green), Alignment.BottomCenter
        ) {
            Text("Ejemplo 4")
        }
    }
}

@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MyRow() {
    /*Row(Modifier.fillMaxSize() , Arrangement.SpaceBetween) {
        Text(text = "hola kevin" , Modifier.background(Color.Cyan))
        Text(text = "hola kevin")
        Text(text = "hola kevin")
    }*/
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        Text(text = "hola kevin", Modifier.width(100.dp))
        Text(text = "hola kevin", Modifier.width(100.dp))
        Text(text = "hola kevin", Modifier.width(100.dp))
        Text(text = "hola kevin", Modifier.width(100.dp))
        Text(text = "hola kevin", Modifier.width(100.dp))
        Text(text = "hola kevin", Modifier.width(100.dp))
    }
}

@Composable
fun MyColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            ), verticalArrangement = Arrangement.Center
    ) {

        Text(
            "ejemplo 1", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "ejemplo 2", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )

    }
}

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .width(200.dp)
                .height(200.dp)
                .background(Color.Cyan), contentAlignment = Alignment.Center
        ) {
            Text(text = "esto es un ejemplo")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyNewAppComposeTheme {
        MyStateExample()
    }
}






