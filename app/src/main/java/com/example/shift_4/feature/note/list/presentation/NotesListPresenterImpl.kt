package com.example.shift_4.feature.note.list.presentation

import com.example.common.Note
import com.example.shift_4.feature.note.list.di.NotesListModelFactory
import com.example.shift_4.feature.note.list.domain.NotesListModel

class NotesListPresenterImpl(private var view: NotesListView
): NotesListPresenter {

    private var model: NotesListModel = NotesListModelFactory().create()



    override suspend fun onViewAttached() {
        view.showNotes(getPage(0, 10))
    }

    override fun onNoteItemClick(note: Note) {
        view.navigateToNoteDetails(note)
    }

    override suspend fun update() {
        view.showNotes(getPage(0, 10))
    }

    override suspend fun getPage(start: Long, size: Int): ArrayList<Note>? = model.getPage(start, size)

    override suspend fun getNotesList(): ArrayList<Note>? = model.getNotesList()

    override suspend fun deleteNote(noteId: Long) {
        model.deleteNote(noteId)
        update()
    }
}