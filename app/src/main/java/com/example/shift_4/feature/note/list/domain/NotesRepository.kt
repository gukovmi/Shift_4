package com.example.shift_4.feature.note.list.domain

import com.example.shift_4.feature.note.domain.entity.Note

interface NotesRepository {
    fun getNotes(): ArrayList<Note>
    fun deleteNote(position: Int)
}