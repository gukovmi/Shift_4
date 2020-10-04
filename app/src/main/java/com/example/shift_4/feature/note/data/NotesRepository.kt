package com.example.shift_4.feature.note.data

import com.example.common.Note
import io.reactivex.Completable
import io.reactivex.Single


interface NotesRepository {
    fun getNotes(): Single<List<Note>>
    fun getPage(start: Long, size: Int): Single<List<Note>>
    fun deleteNote(noteId: Long): Completable
    fun getNote(noteId: Long): Single<Note>
    fun updateNote(note: Note): Completable
    fun addNote(note: Note): Completable
    fun saveNotesList(notesList: List<Note>): Completable
    fun clearNotes(): Completable
}