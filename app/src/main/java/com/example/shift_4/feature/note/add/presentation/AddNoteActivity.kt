package com.example.shift_4.feature.note.add.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.common.Note
import com.example.shift_4.R
import com.example.shift_4.feature.note.list.presentation.NotesListActivity
import kotlinx.android.synthetic.main.activity_note_add.*

class AddNoteActivity : AppCompatActivity(), AddNoteView {

    private var presenter = AddNotePresenterImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_add)


        presenter.attachView(this)

        addButton.setOnClickListener {

            val noteTitle = newNoteTitle.text.toString()
            val noteDescription = newNoteDescription.text.toString()
            if (noteTitle != "" && noteDescription != "") {
                val newNote = Note(0, noteTitle, noteDescription)
                presenter.addNote(newNote)
                val intent = Intent(this@AddNoteActivity, NotesListActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun initView() {
        Toast.makeText(this, "Enter the note's title and description", Toast.LENGTH_SHORT).show()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}
