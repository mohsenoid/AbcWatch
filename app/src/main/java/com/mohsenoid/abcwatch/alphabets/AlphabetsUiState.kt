package com.mohsenoid.abcwatch.alphabets

import androidx.compose.ui.graphics.Color
import com.mohsenoid.abcwatch.theme.White

data class AlphabetsUiState(
    val isStartVisible: Boolean = true,
    val letter: String = "A",
    val color: Color = White,
)
