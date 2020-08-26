package com.example.shift_4.feature.note.details.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.common.CreateNoteDto
import com.example.common.Note
import com.example.shift_4.R
import com.example.shift_4.feature.note.list.presentation.NotesListActivity
import kotlinx.android.synthetic.main.activity_note_details.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class NoteDetailsActivity : AppCompatActivity(), NoteDetailsView {

    private lateinit var presenter: NoteDetailsPresenter

    private val coroutineScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_details)

        val note: Note = intent.getSerializableExtra("note") as Note

        coroutineScope.launch {
            presenter = NoteDetailsPresenterImpl(this@NoteDetailsActivity)
            presenter.onViewAttached(note.id)
        }

        updateButton.setOnClickListener {
            coroutineScope.launch {
                val noteTitle = noteDetailsTitle.text.toString()
                val noteDescription = noteDetailsDescription.text.toString()
                if (noteTitle != note.title || noteDescription != note.description) {
                    val updatedNote = Note(note.id, noteTitle, noteDescription)
                    presenter.updateNote(updatedNote)
                    Toast.makeText(this@NoteDetailsActivity, "Changes applied", Toast.LENGTH_LONG).show()
                    val intent = Intent(this@NoteDetailsActivity, NotesListActivity::class.java)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this@NoteDetailsActivity, "Fields not changed", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun initView(note: Note) {
        noteDetailsTitle.setText(note.title)
        noteDetailsDescription.setText(note.description)
    }

    override fun onDestroy() {
        coroutineScope.cancel()
        super.onDestroy()
    }

}