package com.example.shift_4.feature.note.details.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.common.CreateNoteDto
import com.example.common.Note
import com.example.shift_4.R
import com.example.shift_4.feature.note.list.presentation.NotesListActivity
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

        updateButton.setOnClickListener {
            MainScope().launch {
                val noteTitle = noteDetailsTitle.text.toString()
                val noteDescription = noteDetailsDescription.text.toString()
                if (noteTitle != note.title || noteDescription != note.description) {
                    val noteDto = CreateNoteDto(noteTitle, noteDescription)
                    presenter.updateNote(note.id, noteDto)
                    Toast.makeText(this@NoteDetailsActivity, "Changes applied", Toast.LENGTH_LONG).show()
                    val intent = Intent(this@NoteDetailsActivity, NotesListActivity::class.java)
                    startActivity(intent)
                }
            }
        }

//        val note: Note = intent.getSerializableExtra("note") as Note
//        noteDetailsTitle.hint=note.title
//        noteDetailsDescription.hint=note.description
    }

    override fun initView(note: Note) {
        noteDetailsTitle.setText(note.title)
        noteDetailsDescription.setText(note.description)
    }
}