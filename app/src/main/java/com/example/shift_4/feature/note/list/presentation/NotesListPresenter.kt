package com.example.shift_4.feature.note.list.presentation

import android.util.Log
import com.example.common.Note
import com.example.shift_4.feature.note.list.di.NotesListModelFactory
import com.example.shift_4.feature.note.list.domain.NotesListModel
import com.example.shift_4.feature.note.presentation.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface NotesListPresenter {
    fun onViewAttached()
    fun onNoteItemClick(note: Note)
    fun getNotesList()
    fun getPage(start: Long, size: Int)
    fun deleteNote(noteId: Long)
    fun makeToast(message: String)
    fun addPageToAdapter(newPage: List<Note>)
    fun initConfigure()
}

class NotesListPresenterImpl : BasePresenter<NotesListView>(),
    NotesListPresenter {
    private lateinit var model: NotesListModel

    override fun onViewAttached() {
        model = NotesListModelFactory().create()
        initConfigure()
    }

    override fun onNoteItemClick(note: Note) {
        view?.navigateToNoteDetails(note)
    }

    override fun getPage(start: Long, size: Int) {
        model.getPage(start, size)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                addPageToAdapter(it)
            }, {
                makeToast(it.localizedMessage)
            }).untilDestroy()
    }

    override fun getNotesList() {
        model.getPage(0, 10)
            .onErrorResumeNext { model.getNotesList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                addPageToAdapter(it)
                Log.e("showNotesList", it.size.toString())
            }, {
                makeToast(it.localizedMessage)
            }).untilDestroy()
    }

    override fun deleteNote(noteId: Long) {
        model.deleteNote(noteId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                makeToast("Note has been deleted")
                initConfigure()
            }, {
                makeToast(it.localizedMessage)
            }).untilDestroy()
    }

    override fun makeToast(message: String) {
        view?.showToast(message)
    }

    override fun addPageToAdapter(newPage: List<Note>) {
        view?.addPageToAdapter(newPage)
    }

    override fun initConfigure() {
        model.getPage(0, 10)
            .onErrorResumeNext { model.getNotesList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.initConfigure(it)
                Log.e("initConfigure", it.size.toString())
            }, {
                makeToast(it.localizedMessage)
            }).untilDestroy()
    }
}