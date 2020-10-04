package com.example.shift_4.feature.note.details.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.common.Note
import com.example.shift_4.R
import com.example.shift_4.feature.note.list.presentation.NotesListActivity
import kotlinx.android.synthetic.main.activity_note_details.*

class NoteDetailsActivity : AppCompatActivity(), NoteDetailsView {

    private var presenter = NoteDetailsPresenterImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_details)

        val note: Note = intent.getSerializableExtra("note") as Note

        presenter.attachView(this)
        presenter.onViewAttached(note.id)

        updateButton.setOnClickListener {
            val noteTitle = noteDetailsTitle.text.toString()
            val noteDescription = noteDetailsDescription.text.toString()
            val updatedNote = Note(note.id, noteTitle, noteDescription)
            presenter.updateNote(updatedNote)
            val intent = Intent(this@NoteDetailsActivity, NotesListActivity::class.java)
            startActivity(intent)
        }
    }

    override fun showNoteDetails(note: Note) {
        noteDetailsTitle.setText(note.title)
        noteDetailsDescription.setText(note.description)
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

}