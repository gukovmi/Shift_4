package com.example.shift_4.feature.note.list.domain

import com.example.shift_4.feature.note.data.NotesRepository


class DeleteNoteUseCase (private val notesRepository: NotesRepository) {

    suspend operator fun invoke(noteId: Long) = notesRepository.deleteNote(noteId)
}