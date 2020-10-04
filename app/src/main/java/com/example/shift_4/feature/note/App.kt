package com.example.shift_4.feature.note

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.shift_4.feature.note.domain.entity.AppDatabase

class App : Application() {
    companion object {
        lateinit var instance: App
        lateinit var db: AppDatabase
        fun appContext(): Context = instance.applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        db = Room.databaseBuilder(
            appContext(),
            AppDatabase::class.java, "notes"
        ).allowMainThreadQueries().build()
    }
}