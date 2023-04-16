package com.mohsenoid.abcwatch.numbers

import androidx.compose.ui.graphics.Color
import com.mohsenoid.abcwatch.theme.White

data class NumbersUiState(
    val isStartVisible: Boolean = true,
    val number: String = "1",
    val color: Color = White,
)
