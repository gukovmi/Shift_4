package com.example.shift_4.feature.note.add.domain

import com.example.common.CreateNoteDto

class AddNoteModelImpl(
    private val addNoteUseCase: AddNoteUseCase
): AddNoteModel {

    override suspend fun addNote(createNoteDto: CreateNoteDto) {
        addNoteUseCase(createNoteDto)
    }

}