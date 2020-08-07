package com.example.shift_4.feature.note.list.domain


import com.example.common.Note
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NotesListModelImpl(
    private val getNotesListUseCase: GetNotesListUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
): NotesListModel {


    override suspend fun getNotesList(): ArrayList<Note>? {
        return try {
            getNotesListUseCase()
        } catch (e: Exception) {
            null
        }
    }


        //getNotesListUseCase()


    override suspend fun deleteNote(noteId: Long) {
        deleteNoteUseCase(noteId)
    }
}

