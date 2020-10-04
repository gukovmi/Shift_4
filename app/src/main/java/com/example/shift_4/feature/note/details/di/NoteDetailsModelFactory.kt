package com.example.shift_4.feature.note.details.di

import com.example.shift_4.feature.note.App
import com.example.shift_4.feature.note.data.Constants.BASE_URL
import com.example.shift_4.feature.note.data.LocalNoteDataSourceImpl
import com.example.shift_4.feature.note.data.NetworkNoteDataSourceImpl
import com.example.shift_4.feature.note.data.NotesApi
import com.example.shift_4.feature.note.data.NotesRepositoryImpl
import com.example.shift_4.feature.note.details.domain.GetNoteUseCase
import com.example.shift_4.feature.note.details.domain.NoteDetailsModelImpl
import com.example.shift_4.feature.note.details.domain.UpdateNoteUseCase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NoteDetailsModelFactory {

    fun create(): NoteDetailsModelImpl {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

        val api = retrofit.create(NotesApi::class.java)

        val networkNoteDataSource = NetworkNoteDataSourceImpl(api)
        val localNoteDataSource = LocalNoteDataSourceImpl(App.db)
        val notesRepository = NotesRepositoryImpl(networkNoteDataSource, localNoteDataSource)
        val getNoteUseCase = GetNoteUseCase(notesRepository)
        val updateNoteUseCase = UpdateNoteUseCase(notesRepository)

        return NoteDetailsModelImpl(getNoteUseCase, updateNoteUseCase)
    }
}