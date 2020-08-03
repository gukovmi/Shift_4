package com.example.shift_4.feature.note.list.data

import com.example.shift_4.feature.note.domain.entity.Note
import com.example.shift_4.feature.note.list.domain.NotesRepository

class NotesRepositoryImpl :NotesRepository {
    var notesList=arrayListOf<Note>(
        Note(
            "title1",
            "description1"
        ),
        Note(
            "title2",
            "description2"
        ),
        Note(
            "title3",
            "description3"
        )
    )

    override fun getNotes(): ArrayList<Note> = notesList


    override fun deleteNote(position: Int) {
        notesList.removeAt(position)
    }

}