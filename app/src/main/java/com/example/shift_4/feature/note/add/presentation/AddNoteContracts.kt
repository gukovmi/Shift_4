package com.example.shift_4.feature.note.add.presentation

import com.example.common.CreateNoteDto

interface AddNoteView {
    fun initView()
}

interface AddNotePresenter {
    suspend fun onViewAttached()
    suspend fun addNote(createNoteDto: CreateNoteDto)
}