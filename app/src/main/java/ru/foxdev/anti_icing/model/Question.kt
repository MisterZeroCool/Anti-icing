package ru.foxdev.anti_icing.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity
data class Question(@PrimaryKey val id: UUID = UUID.randomUUID(),
                    var title: String = "",
                    var answer: String = "",
                    var isSolved: Boolean = false,
                    var date: Date = Date())