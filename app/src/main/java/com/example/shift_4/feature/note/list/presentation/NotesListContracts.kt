package com.example.shift_4.feature.note.list.presentation

import com.example.shift_4.feature.note.domain.entity.Note


    interface INotesListView {
        fun initView(notesList: ArrayList<Note>?)
        fun navigateToNoteDetails(note: Note)
        fun updateView(notesList: ArrayList<Note>?)
    }

    interface INotesListPresenter {
        fun onViewAttached()
        fun onNoteItemClick(note: Note)
        fun update()
        fun getNotesList(): ArrayList<Note>?
        fun deleteNote(position: Int)
    }


