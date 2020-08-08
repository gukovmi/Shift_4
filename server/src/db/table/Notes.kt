package com.example.server.db.table

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Notes : Table() {
    val id: Column<Long> = Notes.long("id").autoIncrement().primaryKey()
    var title: Column<String> = Notes.text("title")
    var description: Column<String> = Notes.text("description")
}