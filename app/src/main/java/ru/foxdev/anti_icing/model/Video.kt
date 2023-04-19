package ru.foxdev.anti_icing.model

import android.widget.VideoView
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID
@Entity
class Video (@PrimaryKey val id: UUID = UUID.randomUUID(),
             var title: String = "",
             var description: String = "",
             var video: VideoView,
             var date_of_creation: Date = Date()
)