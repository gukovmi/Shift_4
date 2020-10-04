package com.example.shift_4.feature.note.add.domain

import com.example.common.Note
import io.reactivex.Completable

interface AddNoteModel {
    fun addNote(note: Note): Completable
}