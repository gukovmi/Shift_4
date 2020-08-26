package com.example.shift_4.feature.note.add.domain

import com.example.common.CreateNoteDto
import com.example.common.Note

class AddNoteModelImpl(
    private val addNoteUseCase: AddNoteUseCase
): AddNoteModel {

    override suspend fun addNote(note: Note) {
        addNoteUseCase(note)
    }

}