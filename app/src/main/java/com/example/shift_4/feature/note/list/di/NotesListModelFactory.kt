package com.example.shift_4.feature.note.list.di

import com.example.shift_4.feature.note.data.Constants.BASE_URL
import com.example.shift_4.feature.note.data.NetworkNoteDataSourceImpl
import com.example.shift_4.feature.note.data.NotesApi
import com.example.shift_4.feature.note.data.NotesRepositoryImpl
import com.example.shift_4.feature.note.list.domain.DeleteNoteUseCase
import com.example.shift_4.feature.note.list.domain.GetNotesListUseCase
import com.example.shift_4.feature.note.list.domain.GetPageUseCase
import com.example.shift_4.feature.note.list.domain.NotesListModelImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NotesListModelFactory {

    fun create() : NotesListModelImpl {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        val api = retrofit.create(NotesApi::class.java)

        val networkNoteDataSource = NetworkNoteDataSourceImpl(api)
        val notesRepository=NotesRepositoryImpl(networkNoteDataSource)
        val getNotesListUseCase = GetNotesListUseCase(notesRepository)
        val getPageUseCase=GetPageUseCase(notesRepository)
        val deleteNoteUseCase=DeleteNoteUseCase(notesRepository)

        return NotesListModelImpl(getNotesListUseCase, deleteNoteUseCase, getPageUseCase)
    }
}