package com.example.shift_4.feature.note.list.data

import com.example.common.CreateNoteDto
import com.example.shift_4.feature.note.list.domain.NotesRepository

class NotesRepositoryImpl(
    private val networkNoteDataSource: NetworkNoteDataSource
) :NotesRepository {


    override fun getNotes(): ArrayList<CreateNoteDto> = networkNoteDataSource.getNotes()


    override fun deleteNote(position: Int) {
        //notesList.removeAt(position)
    }

}