package com.example.shift_4.feature.note.list.data

import com.example.common.Note
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NotesApi {
    @GET("/notes")
    suspend fun getAll(): ArrayList<Note>

    @DELETE("/notes")
    suspend fun deleteNote(
        @Query("id") noteId: Long
    )
}