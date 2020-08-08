package com.example.shift_4.feature.note.list.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.Note
import com.example.shift_4.R
import com.example.shift_4.feature.note.add.presentation.AddNoteActivity
import com.example.shift_4.feature.note.details.presentation.NoteDetailsActivity
import kotlinx.android.synthetic.main.activity_notes_list.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class NotesListActivity : AppCompatActivity(), NotesListView {

    private lateinit var presenter: NotesListPresenter

    private var notesListAdapter: NotesListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_list)

        MainScope().launch {
            presenter = NotesListPresenterImpl(this@NotesListActivity)
            presenter.onViewAttached()
        }

        addNoteButton.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        MainScope().launch {
            presenter = NotesListPresenterImpl(this@NotesListActivity)
            presenter.onViewAttached()
        }
    }

    override fun initView(notesList: ArrayList<Note>?) {
        if (notesList.isNullOrEmpty()) {
            Toast.makeText(this, "Notes list is empty!", Toast.LENGTH_LONG).show()
        } else {

            notesListAdapter = NotesListAdapter(
                this,
                notesList = notesList,
                onNoteItemClick = { note -> presenter.onNoteItemClick(note) },
                onDeleteNoteItemClick = { noteId ->
                    MainScope().launch {
                        presenter.deleteNote(noteId)
                    }
                })

            notesListRecyclerView.layoutManager = LinearLayoutManager(this)
            notesListRecyclerView.adapter = notesListAdapter
        }
    }

    override fun navigateToNoteDetails(note: Note) {
        val intent = Intent(this, NoteDetailsActivity::class.java)
        intent.putExtra("note", note)
        startActivity(intent)
    }

    override fun updateView(notesList: ArrayList<Note>?) {
        if (notesList.isNullOrEmpty()) {
            notesListRecyclerView.adapter=null
            Toast.makeText(this, "Notes list is empty!", Toast.LENGTH_LONG).show()
        }
        else {
            notesListAdapter = NotesListAdapter(
                    this,
                    notesList = notesList,
                    onNoteItemClick = { note -> presenter.onNoteItemClick(note) },
                    onDeleteNoteItemClick = { position ->
                        MainScope().launch {
                            presenter.deleteNote(position.toLong())
                        }
                    })

            notesListRecyclerView.layoutManager = LinearLayoutManager(this)
            notesListRecyclerView.adapter = notesListAdapter
        }
    }
}
