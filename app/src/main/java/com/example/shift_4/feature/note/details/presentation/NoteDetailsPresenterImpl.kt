package com.example.shift_4.feature.note.details.presentation

import com.example.common.CreateNoteDto
import com.example.common.Note
import com.example.shift_4.feature.note.details.di.NoteDetailsModelFactory
import com.example.shift_4.feature.note.details.domain.NoteDetailsModel

class NoteDetailsPresenterImpl(private var view: NoteDetailsView
): NoteDetailsPresenter {

    private var model: NoteDetailsModel = NoteDetailsModelFactory().create()

    override suspend fun onViewAttached(noteId: Long) {
        view.initView(getNote(noteId))
    }

    override suspend fun updateNote(noteId: Long, createNoteDto: CreateNoteDto) {
        model.updateNote(noteId, createNoteDto)
    }

    override suspend fun getNote(noteId: Long): Note =
        model.getNote(noteId)

}