package com.example.shift_4.feature.note.list.domain

import com.example.common.Note
import com.example.shift_4.feature.note.data.NotesRepository

class GetPageUseCase(private val notesRepository: NotesRepository) {

    suspend operator fun invoke(start: Long, size:Int) : ArrayList<Note> = notesRepository.getPage(start, size)
}