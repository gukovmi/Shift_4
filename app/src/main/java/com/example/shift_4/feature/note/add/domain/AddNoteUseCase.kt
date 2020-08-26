package com.example.shift_4.feature.note.add.domain

import com.example.common.CreateNoteDto
import com.example.common.Note
import com.example.shift_4.feature.note.data.NotesRepository

class AddNoteUseCase (private val notesRepository: NotesRepository) {

    suspend operator fun invoke(note: Note) {
        notesRepository.addNote(note)
    }
}