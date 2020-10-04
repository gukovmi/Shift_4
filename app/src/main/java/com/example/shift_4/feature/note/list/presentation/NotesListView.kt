package com.example.shift_4.feature.note.list.presentation

import com.example.common.Note
import com.example.shift_4.feature.note.presentation.base.BaseView

interface NotesListView : BaseView {
    fun navigateToNoteDetails(note: Note)
    fun showToast(message: String)
    fun addPageToAdapter(newPage: List<Note>)
    fun initConfigure(notesList: List<Note>)
}






