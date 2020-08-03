package com.example.shift_4.feature.note.list.presentation

import com.example.shift_4.feature.note.domain.entity.Note
import com.example.shift_4.feature.note.list.di.NotesListModelFactory
import com.example.shift_4.feature.note.list.domain.NotesListModel

class NotesListPresenter(private var view: INotesListView
): INotesListPresenter {

    private var model: NotesListModel = NotesListModelFactory().create()



    override fun onViewAttached() {
        view.initView(getNotesList())
    }

    override fun onNoteItemClick(note: Note) {
        view.navigateToNoteDetails(note)
    }

    override fun update() {
        view.updateView(getNotesList())
    }

    override fun getNotesList(): ArrayList<Note>? = model.getNotesList()

    override fun deleteNote(position: Int) {
        model.deleteNote(position)
        update()
    }
}