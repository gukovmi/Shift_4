package com.example.shift_4.feature.note.data

import com.example.common.CreateNoteDto
import com.example.common.Note

interface NetworkNoteDataSource {
    suspend fun getNotes(): ArrayList<Note>
    suspend fun getPage(start: Long, size: Int): ArrayList<Note>
    suspend fun deleteNote(noteId: Long)
    suspend fun getNote(noteId: Long): Note
    suspend fun updateNote(note: Note)
    suspend fun addNote(note: Note)
}

class NetworkNoteDataSourceImpl(private val api: NotesApi) : NetworkNoteDataSource {
    override suspend fun getNotes(): ArrayList<Note> =
        api.getAll()

    override suspend fun getPage(start: Long, size: Int): ArrayList<Note> =
        api.getPage(start, size)

    override suspend fun deleteNote(noteId: Long) {
        api.deleteNote(noteId)
    }

    override suspend fun getNote(noteId: Long): Note =
        api.getNote(noteId)

    override suspend fun updateNote(note: Note) {
        api.updateNote(note)
    }

    override suspend fun addNote(note: Note) {
        api.addNote(note)
    }


}