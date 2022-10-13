package com.magicworld.jetpackcomposecatalog

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable

@Composable
fun MyDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onComfirm: () -> Unit
    ) {
    if (show) {

        AlertDialog(
            onDismissRequest = {onDismiss()},
            title = { Text(text = "Soy un titulo") },
            text = { Text(text = "soy un desripcion :D") },
            confirmButton = {
                TextButton(onClick = {onComfirm()}) {
                    Text(text = "Confirmar")
                }
            },
            dismissButton = {
                TextButton(onClick = {onDismiss() }) {
                    Text(text = "Rechazar")
                }
            }
        )
    }
}