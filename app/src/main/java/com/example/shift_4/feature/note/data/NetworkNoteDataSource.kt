package com.example.shift_4.feature.note.data

import com.example.common.Note

interface NetworkNoteDataSource {
    suspend fun getNotes(): ArrayList<Note>
    suspend fun deleteNote(noteId: Long)
    suspend fun getNote(noteId: Long): Note
    suspend fun updateNote(note: Note)
}

class NetworkNoteDataSourceImpl(private val api: NotesApi) : NetworkNoteDataSource {
    override suspend fun getNotes(): ArrayList<Note> =
        api.getAll()

    override suspend fun deleteNote(noteId: Long) {
        api.deleteNote(noteId)
    }

    override suspend fun getNote(noteId: Long): Note =
        api.getNote(noteId)


    override suspend fun updateNote(note: Note) {
        api.updateNote(note.id , note.title, note.description)
    }


}