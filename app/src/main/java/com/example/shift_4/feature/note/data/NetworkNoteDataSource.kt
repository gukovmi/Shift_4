package com.example.shift_4.feature.note.data

import com.example.common.Note
import io.reactivex.Completable
import io.reactivex.Single

interface NetworkNoteDataSource {
    fun getNotes(): Single<List<Note>>
    fun getPage(start: Long, size: Int): Single<List<Note>>
    fun deleteNote(noteId: Long): Completable
    fun getNote(noteId: Long): Single<Note>
    fun updateNote(note: Note): Completable
    fun addNote(note: Note): Completable
}

class NetworkNoteDataSourceImpl(private val api: NotesApi) : NetworkNoteDataSource {
    override fun getNotes(): Single<List<Note>> =
        api.getAll()

    override fun getPage(start: Long, size: Int): Single<List<Note>> =
        api.getPage(start, size)

    override fun deleteNote(noteId: Long): Completable =
        api.deleteNote(noteId)

    override fun getNote(noteId: Long): Single<Note> =
        api.getNote(noteId)

    override fun updateNote(note: Note): Completable =
        api.updateNote(note)

    override fun addNote(note: Note): Completable =
        api.addNote(note)
}