package com.example.shift_4.feature.note.domain.entity

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.common.Note

@Database(entities = arrayOf(Note::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}