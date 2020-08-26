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
            Notes.selectAll().orderBy(Notes.id to SortOrder.ASC).map { it.toNote() }
        }

    suspend fun getPage(start: Long, size: Int) =
        dbQuery {
            if (Notes.selectAll().count()>=start.toInt()+size) {
                Notes.selectAll().orderBy(Notes.id to SortOrder.ASC).map { it.toNote() }.subList(start.toInt(), start.toInt() + size)
            }
            else{
                Notes.selectAll().orderBy(Notes.id to SortOrder.ASC).map { it.toNote() }.subList(start.toInt(), Notes.selectAll().count())
            }
        }

    suspend fun add(note: Note) {
        dbQuery {
            Notes.insert{ insertStatement ->
                insertStatement[title] = note.title
                insertStatement[description] = note.description
            }
            Notes.selectAll().orderBy(Notes.id to SortOrder.ASC)
        }
    }

    suspend fun delete(noteId: Long) {
        dbQuery {
            Notes.deleteWhere {
                Notes.id.eq(noteId)
            }
        }
    }

    suspend fun getById(noteId: Long) =
        dbQuery {
            Notes.select(Notes.id eq noteId).map{it.toNote()}.first()
        }

    suspend fun update(note: Note) {
        dbQuery {
            Notes.update({ Notes.id eq note.id })
            { updateStatement ->
                updateStatement[title] = note.title
                updateStatement[description] = note.description
            }
        }
    }

}