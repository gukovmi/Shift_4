package com.example.shift_4.feature.note.details.domain

import com.example.common.Note
import io.reactivex.Single


class NoteDetailsModelImpl(
    private val getNoteUseCase: GetNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase
) : NoteDetailsModel {
    override fun getNote(noteId: Long): Single<Note> =
        getNoteUseCase(noteId)

    override fun updateNote(note: Note) =
        updateNoteUseCase(note)
}