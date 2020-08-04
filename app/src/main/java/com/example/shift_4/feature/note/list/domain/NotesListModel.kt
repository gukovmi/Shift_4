package com.example.shift_4.feature.note.list.domain

import com.example.common.CreateNoteDto

interface NotesListModel {
    fun getNotesList(): ArrayList<CreateNoteDto>?
    fun deleteNote(position: Int)
}