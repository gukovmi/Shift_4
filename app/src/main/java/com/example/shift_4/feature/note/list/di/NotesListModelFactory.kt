package com.example.shift_4.feature.note.list.di

import com.example.shift_4.feature.note.list.data.NotesRepositoryImpl
import com.example.shift_4.feature.note.list.domain.DeleteNoteUseCase
import com.example.shift_4.feature.note.list.domain.GetNotesListUseCase
import com.example.shift_4.feature.note.list.domain.NotesListModelImpl

class NotesListModelFactory {
    fun create() : NotesListModelImpl {
        val notesRepository=NotesRepositoryImpl()
        val getNotesListUseCase = GetNotesListUseCase(notesRepository)
        val deleteNoteUseCase=DeleteNoteUseCase(notesRepository)
        val notesListModel = NotesListModelImpl(getNotesListUseCase, deleteNoteUseCase)

        return notesListModel
    }
}