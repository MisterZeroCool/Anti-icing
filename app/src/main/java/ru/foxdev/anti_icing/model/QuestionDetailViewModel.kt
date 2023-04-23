package ru.foxdev.anti_icing.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import ru.foxdev.anti_icing.repository.Anti_icingRepository
import java.util.*

class QuestionDetailViewModel(): ViewModel() {

    private val antiicingRepository = Anti_icingRepository.get()
    private val questionIdLiveData = MutableLiveData<UUID>()

    var questionLiveData: LiveData<Question?> = Transformations.switchMap(questionIdLiveData){
            questionId ->antiicingRepository.getQuestion(questionId)
    }



    fun loadQuestion(questionId: UUID){
        questionIdLiveData.value = questionId
    }
}