package com.example.shift_4.feature.note.list.domain

import com.example.shift_4.feature.note.data.NotesRepository
import io.reactivex.Completable


class DeleteNoteUseCase(private val notesRepository: NotesRepository) {

    operator fun invoke(noteId: Long): Completable = notesRepository.deleteNote(noteId)
}