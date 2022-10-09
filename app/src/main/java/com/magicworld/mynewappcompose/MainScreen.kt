package com.magicworld.mynewappcompose

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
/*
@Preview(
    name = "Preview 1",
    showBackground = true,
    showSystemUi = true,
    apiLevel = 29,
    device = Devices.NEXUS_5
)
@Composable
fun MyTestSuperText() {
    MySuperText(name = "Kevin")
}

@Composable
fun MySuperText(name: String) {
    Text(
        text = "Magic World devs $name :D ", modifier = Modifier
            .height(50.dp)
            .width(300.dp)
            .clickable { }
            .fillMaxSize().padding(20.dp)
    )
}*/
