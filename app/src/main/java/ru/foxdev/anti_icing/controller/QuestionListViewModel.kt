package ru.foxdev.anti_icing.controller

import androidx.lifecycle.ViewModel
import ru.foxdev.anti_icing.repository.Anti_icingRepository

class QuestionListViewModel: ViewModel() {
    private val anti_icingRepository = Anti_icingRepository.get()
    val questionListLiveData = anti_icingRepository.getQuestions()
}