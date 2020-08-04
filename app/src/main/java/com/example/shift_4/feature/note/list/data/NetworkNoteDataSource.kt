package com.example.shift_4.feature.note.list.data

import com.example.common.Note

interface NetworkNoteDataSource {
    fun getNotes(): ArrayList<Note>
}

class NetworkNoteDataSourceImpl : NetworkNoteDataSource {
    override fun getNotes(): ArrayList<Note> = arrayListOf<Note>(
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