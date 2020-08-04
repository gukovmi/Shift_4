package com.example.shift_4.feature.note.list.presentation

import com.example.common.CreateNoteDto
import com.example.shift_4.feature.note.list.di.NotesListModelFactory
import com.example.shift_4.feature.note.list.domain.NotesListModel

class NotesListPresenter(private var view: INotesListView
): INotesListPresenter {

    private var model: NotesListModel = NotesListModelFactory().create()



    override fun onViewAttached() {
        view.initView(getNotesList())
    }

    override fun onNoteItemClick(note: CreateNoteDto) {
        view.navigateToNoteDetails(note)
    }

    override fun update() {
        view.updateView(getNotesList())
    }

    override fun getNotesList(): ArrayList<CreateNoteDto>? = model.getNotesList()

    override fun deleteNote(position: Int) {
        model.deleteNote(position)
        update()
    }
}