package com.example.shift_4.feature.note.list.domain

import com.example.common.CreateNoteDto


interface NotesRepository {
    fun getNotes(): ArrayList<CreateNoteDto>
    fun deleteNote(position: Int)
}