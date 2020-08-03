package com.example.shift_4.feature.note.details.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shift_4.R
import com.example.shift_4.feature.note.domain.entity.Note
import kotlinx.android.synthetic.main.activity_note_details.*

class NoteDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_details)

        val note: Note = intent.getSerializableExtra("note") as Note
        noteDetailsTittle.text=note.tittle
        noteDetailsDescription.text=note.description
    }
}