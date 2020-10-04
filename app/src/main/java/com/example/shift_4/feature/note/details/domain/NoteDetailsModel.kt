package com.example.shift_4.feature.note.details.domain

import com.example.common.Note
import io.reactivex.Completable
import io.reactivex.Single

interface NoteDetailsModel {
    fun getNote(noteId: Long): Single<Note>
    fun updateNote(note: Note): Completable
}