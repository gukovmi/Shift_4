package com.example.shift_4.feature.note.details.domain

import com.example.common.CreateNoteDto
import com.example.common.Note
import com.example.shift_4.feature.note.data.NotesRepository

class UpdateNoteUseCase(private val notesRepository: NotesRepository) {

    suspend operator fun invoke(noteId: Long, createNoteDto: CreateNoteDto)  {
        notesRepository.updateNote(noteId, createNoteDto)
    }
}