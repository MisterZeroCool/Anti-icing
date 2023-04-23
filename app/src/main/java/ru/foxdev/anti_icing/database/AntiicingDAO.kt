package ru.foxdev.anti_icing.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ru.foxdev.anti_icing.model.Question
import java.util.UUID

@Dao
interface AntiicingDAO {
    @Query("SELECT * FROM question")
    fun getQuestions(): LiveData<List<Question>>

    @Query("SELECT * FROM question WHERE id=(:id)")
    fun getQuestion(id: UUID): LiveData<Question?>

    @Insert
    fun addQuestion(question: Question) //remove this before pushing

    @Update
    fun updateQuestion(question: Question)
}