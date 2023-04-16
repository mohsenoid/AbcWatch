package com.mohsenoid.abcwatch

import com.mohsenoid.abcwatch.alphabets.AlphabetsViewModel
import com.mohsenoid.abcwatch.numbers.NumbersViewModel
import com.mohsenoid.abcwatch.speech.SpeechHelper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        SpeechHelper(context = get())
    }

    viewModel {
        AlphabetsViewModel(speechHelper = get())
    }

    viewModel {
        NumbersViewModel(speechHelper = get())
    }
}