package com.magicworld.jetpackcomposecatalog

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
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp

@Composable
fun MyProgress() {
    var showLoading by rememberSaveable { mutableStateOf(false) }
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(strokeWidth = 10.dp)
            LinearProgressIndicator(
                Modifier.padding(top = 24.dp),
                color = Color.Green,
                backgroundColor = Color.Black
            )
        }
        Button(onClick = { showLoading = !showLoading }, Modifier.padding(top = 10.dp)) {
            Text("Cargar perfil")
        }

    }
}

@Composable
fun MyProgressAdvance() {
    var progressStatus by rememberSaveable { mutableStateOf(0f) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = progressStatus)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                if (progressStatus <= 0.99f) progressStatus += 0.1f else progressStatus = 0.1f
            }, Modifier.padding(end = 5.dp)) {
                Text(text = "Incrementar")
            }
            Button(onClick = { if (progressStatus >= 0.1f) progressStatus -= 0.1f }) {
                Text(text = "Reducir")
            }
        }
    }
}

@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(false) }
    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = false,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Gray,
            uncheckedTrackColor = Color.Red,
            uncheckedTrackAlpha = 0.1f,
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Cyan,
            checkedTrackAlpha = 0.3f,
            disabledCheckedThumbColor = Color.DarkGray,
            disabledCheckedTrackColor = Color.LightGray,
            disabledUncheckedThumbColor = Color.Red,
            disabledUncheckedTrackColor = Color.Magenta
        )
    )
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(false) }
    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = false,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Magenta,
            checkmarkColor = Color.Yellow
        )
    )
}

@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable { mutableStateOf(false) }
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Text(text = "Ejemplo 1")
        Spacer(modifier = Modifier.width(8.dp))
    }
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map { title ->
        var status by rememberSaveable { mutableStateOf(false) }

        CheckInfo(
            title = title,
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus }
        )
    }
}

@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {

    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun MyRadioButton() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = true, onClick = { }, colors = RadioButtonDefaults.colors(
                selectedColor = Color.Magenta,
                unselectedColor = Color.Red,
                disabledColor = Color.Blue
            )
        )
        Text(text = "Ejemplo 1")
    }
}

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {

    Column(Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "kevin", onClick = { onItemSelected("kevin") })
            Text(text = "kevin")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "pedro", onClick = { onItemSelected("pedro") })
            Text(text = "pedro")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == "andres", onClick = { onItemSelected("andres") })
            Text(text = "andres")
        }
    }
}