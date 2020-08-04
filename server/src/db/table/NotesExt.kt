package com.example.server.db.table

import com.example.common.CreateNoteDto

import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toNote() = CreateNoteDto(
    id = this[Notes.id],
    title = this[Notes.title],
    description = this[Notes.description]
)