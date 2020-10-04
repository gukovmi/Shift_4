package com.example.shift_4.feature.note.data

import com.example.common.Note
import com.example.shift_4.feature.note.domain.entity.AppDatabase
import io.reactivex.Completable
import io.reactivex.Single

interface LocalNoteDataSource {
    fun getNotes(): Single<List<Note>>
    fun getPage(start: Long, size: Int): Single<List<Note>>
    fun deleteNote(noteId: Long): Completable
    fun getNote(noteId: Long): Single<Note>
    fun updateNote(note: Note): Completable
    fun addNote(note: Note): Completable
    fun saveNotesList(notesList: List<Note>): Completable
    fun clearNotes(): Completable
}

class LocalNoteDataSourceImpl(private val db: AppDatabase) : LocalNoteDataSource {
    override fun getNotes(): Single<List<Note>> =
        db.noteDao().getAll()

    override fun getPage(start: Long, size: Int): Single<List<Note>> =
        db.noteDao().getPage()

    override fun deleteNote(noteId: Long): Completable =
        db.noteDao().deleteNote(noteId)


    override fun getNote(noteId: Long): Single<Note> =
        db.noteDao().getNote(noteId)

    override fun updateNote(note: Note): Completable =
        db.noteDao().updateNote(note)

    override fun addNote(note: Note): Completable =
        db.noteDao().addNote(note)

    override fun saveNotesList(notesList: List<Note>): Completable =
        db.noteDao().saveNotesList(notesList)

    override fun clearNotes(): Completable =
        db.noteDao().clearNotes()


}