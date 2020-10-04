package com.example.shift_4.feature.note.add.domain

import com.example.common.Note
import com.example.shift_4.feature.note.data.NotesRepository
import io.reactivex.Completable

class AddNoteUseCase(private val notesRepository: NotesRepository) {

    operator fun invoke(note: Note): Completable =
        notesRepository.addNote(note)

}