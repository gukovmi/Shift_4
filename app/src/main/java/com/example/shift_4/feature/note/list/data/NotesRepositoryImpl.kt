package com.example.shift_4.feature.note.list.data

import com.example.common.CreateNoteDto
import com.example.common.Note
import com.example.shift_4.feature.note.list.domain.NotesRepository

class NotesRepositoryImpl(
    private val networkNoteDataSource: NetworkNoteDataSource
) :NotesRepository {


    override suspend fun getNotes(): ArrayList<Note> = networkNoteDataSource.getNotes()


    override suspend fun deleteNote(noteId: Long) {
        networkNoteDataSource.deleteNote(noteId)
    }

}