package com.example.shift_4.feature.note.data

import com.example.common.CreateNoteDto
import com.example.common.Note


interface NotesRepository {
    suspend fun getNotes(): ArrayList<Note>
    suspend fun deleteNote(noteId: Long)
    suspend fun getNote(noteId: Long): Note
    suspend fun updateNote(noteId: Long, createNoteDto: CreateNoteDto)
}