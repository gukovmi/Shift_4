package com.example.shift_4.feature.note.add.domain

import com.example.common.CreateNoteDto
import com.example.common.Note

interface AddNoteModel {
    suspend fun addNote(note: Note)
}