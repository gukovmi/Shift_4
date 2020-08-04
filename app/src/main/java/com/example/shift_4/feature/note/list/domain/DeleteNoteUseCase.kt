package com.example.shift_4.feature.note.list.domain


class DeleteNoteUseCase (private val notesRepository: NotesRepository) {

    operator fun invoke(position: Int) = notesRepository.deleteNote(position)
}