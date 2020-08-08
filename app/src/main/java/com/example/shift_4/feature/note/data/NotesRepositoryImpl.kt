package com.example.shift_4.feature.note.data

import com.example.common.CreateNoteDto
import com.example.common.Note

class NotesRepositoryImpl(
    private val networkNoteDataSource: NetworkNoteDataSource
) : NotesRepository {


    override suspend fun getNotes(): ArrayList<Note> = networkNoteDataSource.getNotes()


    override suspend fun deleteNote(noteId: Long) {
        networkNoteDataSource.deleteNote(noteId)
    }

    override suspend fun getNote(noteId: Long): Note =
        networkNoteDataSource.getNote(noteId)


    override suspend fun updateNote(noteId: Long, createNoteDto: CreateNoteDto) {
        networkNoteDataSource.updateNote(noteId, createNoteDto)
    }

    override suspend fun addNote(createNoteDto: CreateNoteDto) {
        networkNoteDataSource.addNote(createNoteDto)
    }

}