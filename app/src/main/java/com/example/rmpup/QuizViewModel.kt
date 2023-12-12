package com.example.rmpup

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {
    public var currentIndex = 0
    val questionBank = listOf(
        Question(R.string.question_australia, true, false),
        Question(R.string.question_oceans, true, false),
        Question(R.string.question_mideast, false, false),
        Question(R.string.question_africa, false, false),
        Question(R.string.question_americas, true, false),
        Question(R.string.question_asia, true, false)
    )
    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    fun allAnswered(): Boolean {
        var allAnswered = true
        questionBank.forEach {
            if (!it.answered) {
                allAnswered = false
            }
        }
        return allAnswered
    }

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun moveToPrevious() {
        if (currentIndex != 0) {
            currentIndex = (currentIndex - 1) % questionBank.size
        } else {
            currentIndex = questionBank.size - 1
        }
    }

    init {
        Log.d(TAG, "ViewModel instance created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "ViewModel instance about to be destroyed")
    }
}
