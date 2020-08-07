package com.example.shift_4.feature.note.list.data

import com.example.common.CreateNoteDto
import com.example.common.Note

interface NetworkNoteDataSource {
    suspend fun getNotes(): ArrayList<Note>
    suspend fun deleteNote(noteId: Long)
}

class NetworkNoteDataSourceImpl(private val api: NotesApi) : NetworkNoteDataSource {
    override suspend fun getNotes(): ArrayList<Note> =
        api.getAll()

    override suspend fun deleteNote(noteId: Long) {
        api.deleteNote(noteId)
    }


}