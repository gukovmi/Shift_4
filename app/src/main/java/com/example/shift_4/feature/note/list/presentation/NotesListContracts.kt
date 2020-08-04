package com.example.shift_4.feature.note.list.presentation

import com.example.common.CreateNoteDto



    interface INotesListView {
        fun initView(notesList: ArrayList<CreateNoteDto>?)
        fun navigateToNoteDetails(note: CreateNoteDto)
        fun updateView(notesList: ArrayList<CreateNoteDto>?)
    }

    interface INotesListPresenter {
        fun onViewAttached()
        fun onNoteItemClick(note: CreateNoteDto)
        fun update()
        fun getNotesList(): ArrayList<CreateNoteDto>?
        fun deleteNote(position: Int)
    }


