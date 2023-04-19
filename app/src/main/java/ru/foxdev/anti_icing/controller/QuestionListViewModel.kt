package ru.foxdev.anti_icing.controller

import androidx.lifecycle.ViewModel
import ru.foxdev.anti_icing.model.Question

class QuestionListViewModel: ViewModel() {
    val questions = mutableListOf<Question>()

    init {
        for (i in 0 until 35) {
            val question = Question()
            question.title = "Question #$i"
            question.isSolved = i % 2 == 0
            questions += question
        }
    }
}