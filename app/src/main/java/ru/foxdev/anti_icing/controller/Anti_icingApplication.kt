package ru.foxdev.anti_icing.controller

import android.app.Application
import ru.foxdev.anti_icing.repository.Anti_icingRepository

class Anti_icingApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Anti_icingRepository.initialize(this)
    }
}