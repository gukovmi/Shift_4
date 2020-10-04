package com.example.shift_4.feature.note.list.domain


import com.example.common.Note
import io.reactivex.Completable
import io.reactivex.Single


class NotesListModelImpl(
    private val getNotesListUseCase: GetNotesListUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val getPageUseCase: GetPageUseCase
) : NotesListModel {
    override fun getNotesList(): Single<List<Note>> =
        getNotesListUseCase()

    override fun getPage(start: Long, size: Int): Single<List<Note>> =
        getPageUseCase(start, size)

    override fun deleteNote(noteId: Long): Completable =
        deleteNoteUseCase(noteId)
}

