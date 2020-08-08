package com.example.shift_4.feature.note.details.presentation

import com.example.common.CreateNoteDto
import com.example.common.Note

interface NoteDetailsView {
    fun initView(note: Note)
}

interface NoteDetailsPresenter {
    suspend fun onViewAttached(noteId: Long)
    suspend fun updateNote(noteId: Long, createNoteDto: CreateNoteDto)
    suspend fun getNote(noteId: Long): Note
}