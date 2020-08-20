package com.example.shift_4.feature.note.list.domain

import com.example.common.Note

interface NotesListModel {
    suspend fun getNotesList(): ArrayList<Note>?
    suspend fun getPage(start: Long, size: Int): ArrayList<Note>?
    suspend fun deleteNote(noteId: Long)
}