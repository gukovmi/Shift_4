package com.example.shift_4.feature.note.add.domain

import com.example.common.Note
import io.reactivex.Completable

class AddNoteModelImpl(
    private val addNoteUseCase: AddNoteUseCase
) : AddNoteModel {

    override fun addNote(note: Note): Completable =
        addNoteUseCase(note)

}