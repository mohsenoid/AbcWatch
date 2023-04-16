package com.mohsenoid.abcwatch.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Text
import com.mohsenoid.abcwatch.R

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun SelectorScreenPreview() {
    SelectorScreen()
}

@Composable
fun SelectorScreen(
    modifier: Modifier = Modifier,
    onAbcClicked: () -> Unit = {},
    on123Clicked: () -> Unit = {},
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        selectorButton(
            text = "ABC",
            icon = R.drawable.ic_abc,
            onClick = onAbcClicked
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        selectorButton(
            text = "123",
            icon = R.drawable.ic_123,
            onClick = on123Clicked
        )
    }
}

@Preview()
@Composable
fun selectorButtonPreview() {
    selectorButton(
        text = "123",
        icon = R.drawable.ic_123
    )
}

@Composable
private fun selectorButton(
    text: String,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = { onClick() },
        modifier = modifier,
        colors = ButtonDefaults.secondaryButtonColors(),
    ) {
        Row(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = text
            )
            Spacer(
                modifier = Modifier.width(4.dp)
            )
            Text(text = text)
        }
    }
}



