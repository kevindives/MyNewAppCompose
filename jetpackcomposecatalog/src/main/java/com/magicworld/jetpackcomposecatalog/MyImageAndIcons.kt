package com.magicworld.jetpackcomposecatalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.magicworld.jetpackcomposecatalog.ui.theme.Shapes

@Composable
fun MyImage() {
    Image(
        painter = painterResource(R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        alpha = 0.5f
    )
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Cyan, CircleShape)
//        modifier = Modifier.clip(RoundedCornerShape(25f))

    )
}

@Composable
fun MyIcons() {
    Icon(
        imageVector = Icons.Rounded.Star,
        contentDescription = "Icono",
        tint = Color.Red
    )
}

@Composable
fun MyBadgeBox() {

    BadgedBox(
        badge = { Badge { Text(text = "5") } },
        modifier = Modifier
            .padding(12.dp)
            .background(
                Color.Red,
//                shape = CutCornerShape(5.dp)
//                shape = RectangleShape
                shape = Shapes.small
//                shape = CircleShape
            )

    ) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "")
    }
}