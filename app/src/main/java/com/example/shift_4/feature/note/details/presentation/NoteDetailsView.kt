package com.example.shift_4.feature.note.details.presentation

import com.example.common.Note
import com.example.shift_4.feature.note.presentation.base.BaseView

interface NoteDetailsView : BaseView {
    fun showNoteDetails(note: Note)
    fun showToast(message: String)
}