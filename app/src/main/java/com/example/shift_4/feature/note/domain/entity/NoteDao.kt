package com.example.shift_4.feature.note.domain.entity

import androidx.room.*
import com.example.common.Note
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getAll(): Single<List<Note>>

    @Query("SELECT * FROM notes WHERE note_id = :noteId ")
    fun getNote(noteId: Long): Single<Note>

    @Query("SELECT * FROM notes")
    fun getPage(): Single<List<Note>>

    @Insert
    fun addNote(note: Note): Completable

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveNotesList(notesList: List<Note>): Completable

    @Query("DELETE FROM notes WHERE note_id=:noteId ")
    fun deleteNote(noteId: Long): Completable

    @Update
    fun updateNote(note: Note): Completable

    @Query("DELETE FROM notes")
    fun clearNotes(): Completable
}