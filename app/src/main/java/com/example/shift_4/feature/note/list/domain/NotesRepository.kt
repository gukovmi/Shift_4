package com.example.shift_4.feature.note.list.domain

import com.example.common.Note


interface NotesRepository {
    fun getNotes(): ArrayList<Note>
    fun deleteNote(position: Int)
}