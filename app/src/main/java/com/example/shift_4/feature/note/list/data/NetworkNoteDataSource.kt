package com.example.shift_4.feature.note.list.data

import com.example.common.CreateNoteDto

interface NetworkNoteDataSource {
    fun getNotes(): ArrayList<CreateNoteDto>
}

class NetworkNoteDataSourceImpl : NetworkNoteDataSource {
    override fun getNotes(): ArrayList<CreateNoteDto> = arrayListOf<CreateNoteDto>(
            CreateNoteDto(
                "title1",
                "description1"
            ),
            CreateNoteDto(
                "title2",
                "description2"
            ),
            CreateNoteDto(
                "title3",
                "description3"
            )
        )

}