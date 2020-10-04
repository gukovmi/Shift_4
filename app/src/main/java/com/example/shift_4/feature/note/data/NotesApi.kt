package com.example.shift_4.feature.note.data

import com.example.common.Note
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*

interface NotesApi {
    @GET("/notes")
    fun getAll(): Single<List<Note>>

    @GET("/notes")
    fun getPage(
        @Query("start") start: Long,
        @Query("size") size: Int
    ): Single<List<Note>>

    @DELETE("/notes")
    fun deleteNote(
        @Query("id") noteId: Long
    ): Completable

    @GET("/notes/details")
    fun getNote(
        @Query("id") noteId: Long
    ): Single<Note>

    @PATCH("/notes/details")
    fun updateNote(
        //@Query("id") noteId: Long,
        @Body note: Note
    ): Completable

    @POST("/notes")
    fun addNote(
        @Body note: Note
    ): Completable

}