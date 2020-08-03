package com.example.shift_4.feature.note.list.data

import com.example.shift_4.feature.note.domain.entity.Note
import com.example.shift_4.feature.note.list.domain.NotesRepository

class NotesRepositoryImpl(
    private val networkNoteDataSource: NetworkNoteDataSource
) :NotesRepository {


    override fun getNotes(): ArrayList<Note> = networkNoteDataSource.getNotes()


    override fun deleteNote(position: Int) {
        //notesList.removeAt(position)
    }

}