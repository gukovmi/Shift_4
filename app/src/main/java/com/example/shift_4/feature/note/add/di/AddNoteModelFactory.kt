package com.example.shift_4.feature.note.add.di

import com.example.shift_4.feature.note.add.domain.AddNoteModelImpl
import com.example.shift_4.feature.note.add.domain.AddNoteUseCase
import com.example.shift_4.feature.note.data.NetworkNoteDataSourceImpl
import com.example.shift_4.feature.note.data.NotesApi
import com.example.shift_4.feature.note.data.NotesRepositoryImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AddNoteModelFactory {

    fun create() : AddNoteModelImpl {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://shift-backend.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        val api = retrofit.create(NotesApi::class.java)

        val networkNoteDataSource = NetworkNoteDataSourceImpl(api)
        val notesRepository= NotesRepositoryImpl(networkNoteDataSource)
        val addNoteUseCase = AddNoteUseCase(notesRepository)

        return AddNoteModelImpl(addNoteUseCase)
    }
}