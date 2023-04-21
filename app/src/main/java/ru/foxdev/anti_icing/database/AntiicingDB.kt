package ru.foxdev.anti_icing.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.foxdev.anti_icing.model.Question

@Database(entities = [Question::class], version = 1)
@TypeConverters(QuestionTypeConverters::class)
abstract class AntiicingDB : RoomDatabase() {

    abstract fun anti_icingDao(): AntiicingDAO
}