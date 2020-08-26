package com.example.shift_4.feature.note.data

import com.example.common.CreateNoteDto
import com.example.common.Note
import retrofit2.http.*

interface NotesApi {
    @GET("/notes")
    suspend fun getAll(): ArrayList<Note>

    @GET("/notes")
    suspend fun getPage(
        @Query("start") start: Long,
        @Query("size") size: Int
    ): ArrayList<Note>

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
        //@Query("id") noteId: Long,
        @Body note: Note
    )

    @POST("/notes")
    suspend fun addNote(
        @Body note: Note
    )

}