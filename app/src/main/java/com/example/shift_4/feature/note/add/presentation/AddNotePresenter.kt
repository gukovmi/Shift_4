package com.example.shift_4.feature.note.add.presentation

import com.example.common.Note


interface AddNotePresenter {
    fun addNote(note: Note)
    fun makeToast(message: String)
}