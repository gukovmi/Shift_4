package com.example.shift_4.feature.note.list.presentation

import com.example.common.Note

interface NotesListView {
        fun showNotes(notesList: ArrayList<Note>?)
        fun navigateToNoteDetails(note: Note)
    }

interface NotesListPresenter {
    suspend fun onViewAttached()
    fun onNoteItemClick(note: Note)
    suspend fun update()
    suspend fun getNotesList(): ArrayList<Note>?
    suspend fun getPage(start: Long, size: Int): ArrayList<Note>?
    suspend fun deleteNote(noteId: Long)
}




