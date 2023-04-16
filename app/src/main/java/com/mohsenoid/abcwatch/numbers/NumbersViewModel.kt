package com.mohsenoid.abcwatch.numbers

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.mohsenoid.abcwatch.speech.SpeechHelper
import com.mohsenoid.abcwatch.theme.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class NumbersViewModel(private val speechHelper: SpeechHelper) : ViewModel() {

    private val _uiState = MutableStateFlow(NumbersUiState())
    val uiState by ::_uiState

    fun onClicked() {
        _uiState.update {
            val newDigit = if (it.isStartVisible) {
                1
            } else {
                var nextDigit = it.number.toInt() + 1
                if (nextDigit !in 1..MAX_NUMBER) {
                    nextDigit = 1
                }
                nextDigit
            }

            val color = getColor(newDigit)

            val newNumber = newDigit.toString()

            speechHelper.speak(newNumber)

            it.copy(
                isStartVisible = false,
                number = newNumber,
                color = color
            )
        }
    }

    private fun getColor(digit: Int): Color {
        val colorIndex = digit % COLORS.size
        return COLORS[colorIndex]
    }

    companion object {
        val COLORS = listOf(
            Red,
            Pink,
            Purple,
            Blue,
            Green,
            Yellow,
            Orange
        )

        const val MAX_NUMBER = 20
    }
}