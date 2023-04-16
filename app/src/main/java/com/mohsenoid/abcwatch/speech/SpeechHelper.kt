package com.mohsenoid.abcwatch.speech

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.*

class SpeechHelper(context: Context) {

    private lateinit var textToSpeech: TextToSpeech

    var initState = InitState.IDLE

    init {
        initState = InitState.INITIALIZING

        textToSpeech = TextToSpeech(context) { initResult ->
            initState = if (initResult == TextToSpeech.SUCCESS) {
                val languageResult = textToSpeech.setLanguage(Locale.ENGLISH)
                if (languageResult == TextToSpeech.SUCCESS) {
                    InitState.SUCCESS
                } else {
                    Log.w(TAG, "Error setting language")
                    InitState.ERROR
                }
            } else {
                Log.w(TAG, "Error initializing")
                InitState.ERROR
            }
        }
    }

    fun speak(text: String) {
        if (initState == InitState.SUCCESS) {
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null)
        }
    }

    enum class InitState {
        IDLE, INITIALIZING, SUCCESS, ERROR
    }

    companion object {
        const val TAG = "SpeechHelper"
    }
}