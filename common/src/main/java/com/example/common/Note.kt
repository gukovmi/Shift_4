package com.example.common

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

//class Note(
//    val id:Long,
//    var title:String,
//    var description:String
//): Serializable


@Entity(tableName = "notes")
data class Note(
    @ColumnInfo(name = "note_id")
    @PrimaryKey(autoGenerate = true) var id: Long = 0,

    @ColumnInfo(name = "note_title")
    val title: String,

    @ColumnInfo(name = "note_description")
    val description: String
): Serializable