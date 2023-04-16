package com.mohsenoid.abcwatch.alphabets

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.mohsenoid.abcwatch.speech.SpeechHelper
import com.mohsenoid.abcwatch.theme.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class AlphabetsViewModel(private val speechHelper: SpeechHelper) : ViewModel() {

    private val _uiState = MutableStateFlow(AlphabetsUiState())
    val uiState by ::_uiState

    fun onClicked() {
        _uiState.update {
            val newChar = if (it.isStartVisible) {
                'A'
            } else {
                var nextChar = it.letter[0] + 1
                if (nextChar !in 'A'..'Z') {
                    nextChar = 'A'
                }
                nextChar
            }

            val color = getColor(newChar)

            val newLetter = newChar.toString()

            speechHelper.speak(newLetter)

            it.copy(
                isStartVisible = false,
                letter = newLetter,
                color = color
            )
        }
    }

    private fun getColor(char: Char): Color {
        val colorIndex = char.hashCode() % COLORS.size
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
    }
}