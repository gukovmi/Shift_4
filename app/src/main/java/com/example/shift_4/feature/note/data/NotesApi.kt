package com.example.shift_4.feature.note.data

import com.example.common.CreateNoteDto
import com.example.common.Note
import retrofit2.http.*

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

    @PATCH("/notes/details")
    suspend fun updateNote(
        @Query("id") noteId: Long,
        @Body createNoteDto: CreateNoteDto
    )

    @POST("/notes")
    suspend fun addNote(
        @Body createNoteDto: CreateNoteDto
    )

}