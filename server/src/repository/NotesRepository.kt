package com.example.server.repository

import com.example.common.Note
import com.example.server.db.dbQuery
import com.example.server.db.table.Notes
import com.example.server.db.table.toNote
import org.jetbrains.exposed.sql.selectAll

class NotesRepository {
    suspend fun getAll() =
        dbQuery {
            Notes.selectAll().map { it.toNote() }
        }



//        arrayListOf<Note>(
//        Note(
//            "title1",
//            "description1"
//        ),
//        Note(
//            "title2",
//            "description2"
//        ),
//        Note(
//            "title3",
//            "description3"
//        )
//    )
}