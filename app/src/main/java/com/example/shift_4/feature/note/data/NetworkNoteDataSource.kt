package com.example.shift_4.feature.note.data

import com.example.common.CreateNoteDto
import com.example.common.Note

interface NetworkNoteDataSource {
    suspend fun getNotes(): ArrayList<Note>
    suspend fun deleteNote(noteId: Long)
    suspend fun getNote(noteId: Long): Note
    suspend fun updateNote(noteId: Long, createNoteDto: CreateNoteDto)
}

class NetworkNoteDataSourceImpl(private val api: NotesApi) : NetworkNoteDataSource {
    override suspend fun getNotes(): ArrayList<Note> =
        api.getAll()

    override suspend fun deleteNote(noteId: Long) {
        api.deleteNote(noteId)
    }

    override suspend fun getNote(noteId: Long): Note =
        api.getNote(noteId)


    override suspend fun updateNote(noteId: Long, createNoteDto: CreateNoteDto) {
        api.updateNote(noteId, createNoteDto)
    }


}