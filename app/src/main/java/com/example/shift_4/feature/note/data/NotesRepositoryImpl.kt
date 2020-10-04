package com.example.shift_4.feature.note.data

import com.example.common.Note
import io.reactivex.Completable
import io.reactivex.Single

class NotesRepositoryImpl(
    private val networkNoteDataSource: NetworkNoteDataSource,
    private val localNoteDataSource: LocalNoteDataSource
) : NotesRepository {

    override fun getNotes(): Single<List<Note>> =
        networkNoteDataSource.getNotes()
            .flatMap {
                clearNotes()
                    .andThen(saveNotesList(it))
                    .andThen(Single.just(it))
            }
            .onErrorResumeNext {
                localNoteDataSource.getNotes()
            }

    override fun getPage(start: Long, size: Int): Single<List<Note>> =
        networkNoteDataSource.getPage(start, size)

    override fun deleteNote(noteId: Long): Completable =
        networkNoteDataSource.deleteNote(noteId)

    override fun getNote(noteId: Long): Single<Note> =
        networkNoteDataSource.getNote(noteId)
            .onErrorResumeNext {
                localNoteDataSource.getNote(noteId)
            }

    override fun updateNote(note: Note): Completable =
        networkNoteDataSource.updateNote(note)

    override fun addNote(note: Note): Completable =
        networkNoteDataSource.addNote(note)

    override fun saveNotesList(notesList: List<Note>): Completable =
        localNoteDataSource.saveNotesList(notesList)

    override fun clearNotes(): Completable =
        localNoteDataSource.clearNotes()
}