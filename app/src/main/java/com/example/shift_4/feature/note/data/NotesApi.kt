package com.example.shift_4.feature.note.data

import com.example.common.Note
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Query

interface NotesApi {
    @GET("/notes")
    suspend fun getAll(): ArrayList<Note>

    @DELETE("/notes")
    suspend fun deleteNote(
        @Query("id") noteId: Long
    )

    @GET("/notes/details")
    suspend fun getNote(
        @Query("id") noteId: Long
    ): Note

    @PUT("/notes/details")
    suspend fun updateNote(
        @Query("id") noteId: Long,
        @Query("title") noteTitle: String,
        @Query("description") noteDescription: String
    )

}