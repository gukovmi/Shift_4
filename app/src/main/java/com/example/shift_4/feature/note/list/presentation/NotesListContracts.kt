package com.example.shift_4.feature.note.list.presentation

import com.example.common.CreateNoteDto
import com.example.common.Note


interface INotesListView {
        fun initView(notesList: ArrayList<Note>?)
        fun navigateToNoteDetails(note: Note)
        fun updateView(notesList: ArrayList<Note>?)
    }

    interface INotesListPresenter {
        suspend fun onViewAttached()
        fun onNoteItemClick(note: Note)
        suspend fun update()
        suspend fun getNotesList(): ArrayList<Note>?
        suspend fun deleteNote(noteId: Long)
    }


