package com.example.shift_4.feature.note.add.di

import com.example.shift_4.feature.note.App
import com.example.shift_4.feature.note.add.domain.AddNoteModelImpl
import com.example.shift_4.feature.note.add.domain.AddNoteUseCase
import com.example.shift_4.feature.note.data.LocalNoteDataSourceImpl
import com.example.shift_4.feature.note.data.NetworkNoteDataSourceImpl
import com.example.shift_4.feature.note.data.NotesApi
import com.example.shift_4.feature.note.data.NotesRepositoryImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AddNoteModelFactory {

    fun create(): AddNoteModelImpl {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://shift-backend.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

        val api = retrofit.create(NotesApi::class.java)


        val networkNoteDataSource = NetworkNoteDataSourceImpl(api)
        val localNoteDataSource = LocalNoteDataSourceImpl(App.db)
        val notesRepository = NotesRepositoryImpl(networkNoteDataSource, localNoteDataSource)
        val addNoteUseCase = AddNoteUseCase(notesRepository)

        return AddNoteModelImpl(addNoteUseCase)
    }
}