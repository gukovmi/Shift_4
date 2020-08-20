package com.example.shift_4.feature.note.list.domain


import com.example.common.Note


class NotesListModelImpl(
    private val getNotesListUseCase: GetNotesListUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val getPageUseCase: GetPageUseCase
): NotesListModel {


    override suspend fun getNotesList(): ArrayList<Note>? {
        return try {
            getNotesListUseCase()
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun getPage(start: Long, size: Int): ArrayList<Note>? {
        return try {
            getPageUseCase(start, size)
        } catch (e: Exception) {
            null
        }
    }


    //getNotesListUseCase()


    override suspend fun deleteNote(noteId: Long) {
        deleteNoteUseCase(noteId)
    }
}

