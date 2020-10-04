package com.example.shift_4.feature.note.details.domain

import com.example.common.Note
import com.example.shift_4.feature.note.data.NotesRepository
import io.reactivex.Single

class GetNoteUseCase(private val notesRepository: NotesRepository) {

    operator fun invoke(noteId: Long): Single<Note> = notesRepository.getNote(noteId)
}