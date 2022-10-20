package com.magicworld.jetpackcomposecatalog

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.magicworld.jetpackcomposecatalog.ui.theme.Shapes

@Composable
fun MyConfirmationDialog(show: Boolean, onDismiss: () -> Unit) {

    if (show) {

        Dialog(onDismissRequest = { onDismiss() } , ) {

            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .background(color = Color.White)
            ) {
                MyTitleDialog(title = "Phone ringtone", Modifier.padding(24.dp))
                Divider(Modifier.fillMaxWidth(), color = Color.DarkGray)
                var selected by rememberSaveable { mutableStateOf("") }
                MyRadioButtonList(name = selected, onItemSelected = { selected = it })
                Divider(Modifier.fillMaxWidth(), color = Color.DarkGray)
                Row(
                    Modifier
                        .align(Alignment.End)
                        .padding(8.dp)) {
                    TextButton(onClick = { }) {
                        Text(text = "Cancel")
                    }
                    TextButton(onClick = { }) {
                        Text(text = "Ok")
                    }
                }
            }
        }
    }
}


@Composable
fun MyAlertDialog(show: Boolean, onDismiss: () -> Unit, onComfirm: () -> Unit) {
    if (show) {

        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text(text = "Soy un titulo") },
            text = { Text(text = "soy un desripcion :D") },
            confirmButton = {
                TextButton(onClick = { onComfirm() }) {
                    Text(text = "Confirmar")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Rechazar")
                }
            }
        )
    }
}

@Composable
fun MySimpleCustomDialog(show: Boolean, onDismiss: () -> Unit) {

    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Esto es un ejemplo")
            }
        }
    }
}

@Composable
fun MyCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() }
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTitleDialog(title = "Set backup account")
                AccountItem(email = "ejemplo@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "ejemplo@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "añadir nueva cuenta", drawable = R.drawable.add)
            }

        }
    }
}

@Composable
fun MyTitleDialog(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
}
