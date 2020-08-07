package com.example.shift_4.feature.note.details.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.common.CreateNoteDto
import com.example.common.Note
import com.example.shift_4.R
import com.example.shift_4.feature.note.list.presentation.NotesListPresenter
import com.example.shift_4.feature.note.list.presentation.NotesListPresenterImpl
import kotlinx.android.synthetic.main.activity_note_details.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class NoteDetailsActivity : AppCompatActivity(), NoteDetailsView {

    private lateinit var presenter: NoteDetailsPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_details)

        val note: Note = intent.getSerializableExtra("note") as Note

        MainScope().launch {
            presenter = NoteDetailsPresenterImpl(this@NoteDetailsActivity)

            presenter.onViewAttached(note.id)
        }

//        val note: Note = intent.getSerializableExtra("note") as Note
//        noteDetailsTitle.hint=note.title
//        noteDetailsDescription.hint=note.description
    }

    override fun initView(note: Note) {
        noteDetailsTitle.hint=note.title
        noteDetailsDescription.hint=note.description
    }
}