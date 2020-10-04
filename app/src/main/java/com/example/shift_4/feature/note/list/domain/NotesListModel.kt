package com.example.shift_4.feature.note.list.domain

import com.example.common.Note
import io.reactivex.Completable
import io.reactivex.Single

interface NotesListModel {
    fun getNotesList(): Single<List<Note>>
    fun getPage(start: Long, size: Int): Single<List<Note>>
    fun deleteNote(noteId: Long): Completable
}