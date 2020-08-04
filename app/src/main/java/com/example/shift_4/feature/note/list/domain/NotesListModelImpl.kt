package com.example.shift_4.feature.note.list.domain

import com.example.common.Note

class NotesListModelImpl(
    private val getNotesListUseCase: GetNotesListUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
): NotesListModel {


    override fun getNotesList(): ArrayList<Note>? = getNotesListUseCase()

    override fun deleteNote(position: Int) {
        deleteNoteUseCase(position)
    }

}