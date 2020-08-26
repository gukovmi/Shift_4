package com.example.shift_4.feature.note.data

import com.example.common.CreateNoteDto
import com.example.common.Note

class NotesRepositoryImpl(
    private val networkNoteDataSource: NetworkNoteDataSource
) : NotesRepository {


    override suspend fun getNotes(): ArrayList<Note> = networkNoteDataSource.getNotes()

    override suspend fun getPage(start: Long, size: Int): ArrayList<Note> =
        networkNoteDataSource.getPage(start, size)



    override suspend fun deleteNote(noteId: Long) {
        networkNoteDataSource.deleteNote(noteId)
    }

    override suspend fun getNote(noteId: Long): Note =
        networkNoteDataSource.getNote(noteId)


    override suspend fun updateNote(note: Note) {
        networkNoteDataSource.updateNote(note)
    }

    override suspend fun addNote(note: Note) {
        networkNoteDataSource.addNote(note)
    }

}