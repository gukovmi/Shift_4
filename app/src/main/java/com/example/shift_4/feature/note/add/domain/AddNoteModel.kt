package com.example.shift_4.feature.note.add.domain

import com.example.common.CreateNoteDto

interface AddNoteModel {
    suspend fun addNote(createNoteDto: CreateNoteDto)
}