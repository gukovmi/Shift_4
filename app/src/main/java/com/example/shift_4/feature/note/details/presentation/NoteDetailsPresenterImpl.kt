package com.example.shift_4.feature.note.details.presentation

import com.example.common.Note
import com.example.shift_4.feature.note.details.di.NoteDetailsModelFactory
import com.example.shift_4.feature.note.details.domain.NoteDetailsModel
import com.example.shift_4.feature.note.list.di.NotesListModelFactory
import com.example.shift_4.feature.note.list.domain.NotesListModel
import com.example.shift_4.feature.note.list.presentation.NotesListView

class NoteDetailsPresenterImpl(private var view: NoteDetailsView
): NoteDetailsPresenter {

    private var model: NoteDetailsModel = NoteDetailsModelFactory().create()

    override suspend fun onViewAttached(noteId: Long) {
        view.initView(getNote(noteId))
    }

    override suspend fun updateNote(note: Note) {
        model.updateNote(note)
    }

    override suspend fun getNote(noteId: Long): Note =
        model.getNote(noteId)


}