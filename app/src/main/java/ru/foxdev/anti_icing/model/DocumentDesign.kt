package ru.foxdev.anti_icing.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class DocumentDesign(@PrimaryKey val id: UUID = UUID.randomUUID(),
                          var title: String = "",
                          var description: String = "",
                          var photo: String = "")