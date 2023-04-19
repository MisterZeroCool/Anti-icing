package ru.foxdev.anti_icing.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import ru.foxdev.anti_icing.model.Question
import java.util.UUID

@Dao
interface AntiicingDAO {
    @Query("SELECT * FROM question")
    fun getQuestions(): LiveData<List<Question>>

    @Query("SELECT * FROM question WHERE id=(:id)")
    fun getQuestion(id: UUID): LiveData<Question?>
}