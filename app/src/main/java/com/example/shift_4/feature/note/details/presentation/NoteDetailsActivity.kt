package com.example.shift_4.feature.note.details.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.common.CreateNoteDto
import com.example.shift_4.R
import kotlinx.android.synthetic.main.activity_note_details.*

class NoteDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_details)

        val note: CreateNoteDto = intent.getSerializableExtra("note") as CreateNoteDto
        noteDetailsTitle.text=note.title
        noteDetailsDescription.text=note.description
    }
}