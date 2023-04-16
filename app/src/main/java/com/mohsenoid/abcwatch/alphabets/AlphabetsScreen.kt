package com.mohsenoid.abcwatch.alphabets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text

@Composable
fun AlphabetsScreen(
    state: AlphabetsUiState,
    modifier: Modifier = Modifier,
    onClicked: () -> Unit = {},
) {
    Box(modifier = modifier
        .clickable {
            onClicked()
        }
    ) {
        if (state.isStartVisible) {
            Text(
                text = "Start",
                modifier = Modifier
                    .align(Alignment.Center),
                color = state.color,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
            )
        } else {
            Text(
                text = state.letter,
                modifier = Modifier
                    .align(Alignment.Center),
                color = state.color,
                fontSize = 100.sp,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun AlphabetsScreenPreview() {
    AlphabetsScreen(AlphabetsUiState())
}
