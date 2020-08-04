package com.example.server.repository

import com.example.common.Note

class NotesRepository {
    fun getAll() = arrayListOf<Note>(
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
}