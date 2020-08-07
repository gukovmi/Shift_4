package com.example.server.repository

import com.example.common.CreateNoteDto
import com.example.common.Note
import com.example.server.db.dbQuery
import com.example.server.db.table.Notes
import com.example.server.db.table.toNote
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.update

class NotesRepository {
    suspend fun getAll() =
        dbQuery {
            Notes.selectAll().map { it.toNote() }
        }

    suspend fun add(createNoteDto: CreateNoteDto) {
        dbQuery {
            Notes.insert{ insertStatement ->
                insertStatement[title] = createNoteDto.title
                insertStatement[description] = createNoteDto.description
            }
        }
    }

    suspend fun delete(id: Long) {
        dbQuery {
            Notes.deleteWhere {
                Notes.id.eq(id)
            }
        }
    }

    suspend fun update(note: Note) {
        dbQuery {
            Notes.update({ Notes.id eq note.id })
            {
                this.title=Notes.text(note.title)
                this.description=Notes.text(note.description)


            }
        }
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