package com.example.server.repository

import com.example.common.CreateNoteDto
import com.example.common.Note
import com.example.server.db.dbQuery
import com.example.server.db.table.Notes
import com.example.server.db.table.toNote
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

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

    suspend fun getById(id: Long) =
        dbQuery {
            Notes.select(Notes.id eq id).map{it.toNote()}.first()
        }

    suspend fun update(id: Long, createNoteDto: CreateNoteDto) {
        dbQuery {
            Notes.update({ Notes.id eq id })
            { updateStatement ->
                updateStatement[title] = createNoteDto.title
                updateStatement[description] = createNoteDto.description
            }
        }
    }

}