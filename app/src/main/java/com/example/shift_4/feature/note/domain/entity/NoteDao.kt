package com.example.shift_4.feature.note.domain.entity

import androidx.room.*
import com.example.common.CreateNoteDto
import com.example.common.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getAll(): ArrayList<Note>

    @Query("SELECT * FROM notes WHERE note_id IN (:noteId) ")
    fun getNote(noteId: Long): Note

    @Insert
    fun addNote(note: Note)

    @Query("DELETE FROM notes WHERE note_id=:noteId ")
    fun deleteNote(noteId: Long)

    @Update
    fun updateNote(note: Note)
}