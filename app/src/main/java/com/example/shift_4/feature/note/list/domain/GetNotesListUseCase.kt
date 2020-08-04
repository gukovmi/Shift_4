package com.example.shift_4.feature.note.list.domain

import com.example.common.Note


class GetNotesListUseCase(private val notesRepository: NotesRepository) {

    operator fun invoke() : ArrayList<Note> = notesRepository.getNotes()
}