package com.example.shift_4.feature.note.data

import com.example.common.CreateNoteDto
import com.example.common.Note
import com.example.shift_4.feature.note.domain.entity.NoteDao

interface LocalNoteDataSource {
    suspend fun getNotes(): ArrayList<Note>
//   suspend fun getPage(start: Long, size: Int): ArrayList<Note>
    suspend fun deleteNote(noteId: Long)
    suspend fun getNote(noteId: Long): Note
    suspend fun updateNote(note: Note)
    suspend fun addNote(note: Note)
}

class LocalNoteDataSourceImpl(private val db: NoteDao) : LocalNoteDataSource {
    override suspend fun getNotes(): ArrayList<Note> =
        db.getAll()

//    override suspend fun getPage(start: Long, size: Int): ArrayList<Note> =
//        api.getPage(start, size)

    override suspend fun deleteNote(noteId: Long) {
        db.deleteNote(noteId)
    }

    override suspend fun getNote(noteId: Long): Note =
        db.getNote(noteId)

    override suspend fun updateNote(note: Note) {
        db.updateNote(note)
    }

    override suspend fun addNote(note: Note) {
        db.addNote(note)
    }


}