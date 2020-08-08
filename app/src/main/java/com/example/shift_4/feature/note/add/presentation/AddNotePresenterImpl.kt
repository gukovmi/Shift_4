package com.example.shift_4.feature.note.add.presentation

import com.example.common.CreateNoteDto
import com.example.shift_4.feature.note.add.di.AddNoteModelFactory
import com.example.shift_4.feature.note.add.domain.AddNoteModel

class AddNotePresenterImpl(private var view: AddNoteView
): AddNotePresenter {

    private var model: AddNoteModel= AddNoteModelFactory().create()

    override suspend fun onViewAttached() {
        view.initView()
    }

    override suspend fun addNote(createNoteDto: CreateNoteDto) {
        model.addNote(createNoteDto)
    }
}