package com.example.shift_4.feature.note.list.domain

import com.example.common.CreateNoteDto
import com.example.common.Note


interface NotesRepository {
    suspend fun getNotes(): ArrayList<Note>
    suspend fun deleteNote(noteId: Long)
}