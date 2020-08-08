package com.example.shift_4.feature.note.details.domain

import com.example.common.CreateNoteDto
import com.example.common.Note

interface NoteDetailsModel {
    suspend fun getNote(noteId: Long): Note
    suspend fun updateNote(noteId: Long, createNoteDto: CreateNoteDto)
}