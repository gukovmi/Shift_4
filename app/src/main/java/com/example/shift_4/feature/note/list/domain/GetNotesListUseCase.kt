package com.example.shift_4.feature.note.list.domain

import com.example.common.Note
import com.example.shift_4.feature.note.data.NotesRepository


class GetNotesListUseCase(private val notesRepository: NotesRepository) {

    suspend operator fun invoke() : ArrayList<Note> = notesRepository.getNotes()
}