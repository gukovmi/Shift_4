package com.example.shift_4.feature.note.list.presentation

import com.example.common.Note
import com.example.shift_4.feature.note.list.di.NotesListModelFactory
import com.example.shift_4.feature.note.list.domain.NotesListModel

class NotesListPresenterImpl(private var view: NotesListView
): NotesListPresenter {

    private var model: NotesListModel = NotesListModelFactory().create()



    override suspend fun onViewAttached() {
            view.initView(getNotesList())
    }

    override fun onNoteItemClick(note: Note) {
        view.navigateToNoteDetails(note)
    }

    override suspend fun update() {
        view.updateView(getNotesList())
    }

    override suspend fun getNotesList(): ArrayList<Note>? = model.getNotesList()

    override suspend fun deleteNote(noteId: Long) {
        model.deleteNote(noteId)
        update()
    }
}