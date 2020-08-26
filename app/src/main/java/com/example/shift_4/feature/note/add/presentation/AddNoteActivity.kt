package com.example.shift_4.feature.note.add.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.common.CreateNoteDto
import com.example.common.Note
import com.example.shift_4.R
import com.example.shift_4.feature.note.list.presentation.NotesListActivity
import kotlinx.android.synthetic.main.activity_note_add.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class AddNoteActivity : AppCompatActivity(), AddNoteView {

    private lateinit var presenter: AddNotePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_add)

        MainScope().launch {
            presenter = AddNotePresenterImpl(this@AddNoteActivity)

            presenter.onViewAttached()
        }

        addButton.setOnClickListener {
            MainScope().launch {
                val noteTitle = newNoteTitle.text.toString()
                val noteDescription = newNoteDescription.text.toString()
                if (noteTitle != "" && noteDescription != "") {
                    val newNote = Note(0, noteTitle, noteDescription)
                    presenter.addNote(newNote)
                    Toast.makeText(this@AddNoteActivity, "Note created", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@AddNoteActivity, NotesListActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    override fun initView() {
        Toast.makeText(this, "Enter the note's title and description", Toast.LENGTH_SHORT).show()
    }
}
