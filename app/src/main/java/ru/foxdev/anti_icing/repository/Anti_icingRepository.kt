package ru.foxdev.anti_icing.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import ru.foxdev.anti_icing.database.AntiicingDB
import ru.foxdev.anti_icing.model.Question
import java.lang.IllegalStateException
import java.util.UUID

private const val DATABASE_NAME = "anti-icingDB"

class Anti_icingRepository private constructor(context: Context){

    private val database:AntiicingDB = Room.databaseBuilder(
        context.applicationContext,
        AntiicingDB::class.java,
        DATABASE_NAME
    ).build()

    private val anti_icingDao = database.anti_icingDao()


    fun getQuestions(): LiveData<List<Question>> = anti_icingDao.getQuestions()

    fun getQuestion(id: UUID): LiveData<Question?> = anti_icingDao.getQuestion(id)

    companion object{
        private var INSTANCE: Anti_icingRepository? = null

        fun initialize(context: Context){
            if (INSTANCE == null){
                INSTANCE = Anti_icingRepository(context)
            }
        }

        fun get(): Anti_icingRepository{
            return INSTANCE?: throw IllegalStateException("QuestionRepository must be initialized")
        }
    }
}