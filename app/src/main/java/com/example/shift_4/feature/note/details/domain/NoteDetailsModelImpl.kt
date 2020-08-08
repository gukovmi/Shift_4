package com.example.shift_4.feature.note.details.domain

import com.example.common.CreateNoteDto
import com.example.common.Note


class NoteDetailsModelImpl (
    private val getNoteUseCase: GetNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase
): NoteDetailsModel {
    override suspend fun getNote(noteId: Long): Note =
        getNoteUseCase(noteId)


    override suspend fun updateNote(noteId: Long, createNoteDto: CreateNoteDto) {
        updateNoteUseCase(noteId, createNoteDto)
    }

}