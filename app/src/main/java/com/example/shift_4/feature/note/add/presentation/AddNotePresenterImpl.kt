package com.example.shift_4.feature.note.add.presentation

import com.example.common.Note
import com.example.shift_4.feature.note.add.di.AddNoteModelFactory
import com.example.shift_4.feature.note.add.domain.AddNoteModel
import com.example.shift_4.feature.note.presentation.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddNotePresenterImpl : AddNotePresenter, BasePresenter<AddNoteView>() {

    private var model: AddNoteModel = AddNoteModelFactory().create()

    override fun onViewAttached() {
        view?.initView()
    }

    override fun addNote(note: Note) {
        model.addNote(note)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    makeToast("Note has been added")
                }, {
                    makeToast(it.localizedMessage)
                }
            ).untilDestroy()
    }

    override fun makeToast(message: String) {
        view?.showToast(message)
    }
}