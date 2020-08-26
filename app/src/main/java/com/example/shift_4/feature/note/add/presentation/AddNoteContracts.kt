package com.example.shift_4.feature.note.add.presentation

import com.example.common.CreateNoteDto
import com.example.common.Note

interface AddNoteView {
    fun initView()
}

interface AddNotePresenter {
    suspend fun onViewAttached()
    suspend fun addNote(note: Note)
}