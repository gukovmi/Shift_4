package com.example.shift_4.feature.note.list.domain

import com.example.common.Note
import com.example.shift_4.feature.note.data.NotesRepository
import io.reactivex.Single

class GetPageUseCase(private val notesRepository: NotesRepository) {

    operator fun invoke(start: Long, size: Int): Single<List<Note>> = notesRepository.getPage(start, size)
}