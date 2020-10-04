package com.example.shift_4.feature.note.details.presentation

import com.example.common.Note
import com.example.shift_4.feature.note.details.di.NoteDetailsModelFactory
import com.example.shift_4.feature.note.details.domain.NoteDetailsModel
import com.example.shift_4.feature.note.presentation.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface NoteDetailsPresenter {
    fun onViewAttached(noteId: Long)
    fun updateNote(note: Note)
    fun getNote(noteId: Long)
    fun showNoteDetails(note: Note)
    fun makeToast(message: String)
}

class NoteDetailsPresenterImpl : BasePresenter<NoteDetailsView>(),
    NoteDetailsPresenter {

    private var model: NoteDetailsModel = NoteDetailsModelFactory().create()

    override fun onViewAttached(noteId: Long) {
        getNote(noteId)
    }

    override fun updateNote(note: Note) {
        model.updateNote(note)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                makeToast("Changes applied")
            }, {
                makeToast(it.localizedMessage)
            }).untilDestroy()
    }

    override fun getNote(noteId: Long) {
        model.getNote(noteId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                showNoteDetails(it)
            }, {
                makeToast(it.localizedMessage)
            }).untilDestroy()
    }

    override fun showNoteDetails(note: Note) {
        view?.showNoteDetails(note)
    }

    override fun makeToast(message: String) {
        view?.showToast(message)
    }
}