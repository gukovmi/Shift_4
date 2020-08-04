package com.example.shift_4.feature.note.list.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.CreateNoteDto
import com.example.shift_4.R
import com.example.shift_4.feature.note.details.presentation.NoteDetailsActivity
import kotlinx.android.synthetic.main.activity_notes_list.*

class NotesListActivity : AppCompatActivity(), INotesListView {

    private lateinit var presenter: INotesListPresenter

    private var notesListAdapter: NotesListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_list)

        presenter = NotesListPresenter(this)
        presenter.onViewAttached()
    }

    override fun initView(notesList: ArrayList<CreateNoteDto>?) {
        if (notesList.isNullOrEmpty()) {
            Toast.makeText(this, "Notes list is empty!", Toast.LENGTH_LONG).show()
        }
        else {
            notesListAdapter = NotesListAdapter(
                    this,
                    notesList = notesList,
                    onNoteItemClick = { note -> presenter.onNoteItemClick(note) },
                    onDeleteNoteItemClick = { position -> presenter.deleteNote(position) })

            notesListRecyclerView.layoutManager = LinearLayoutManager(this)
            notesListRecyclerView.adapter = notesListAdapter
        }
    }

    override fun navigateToNoteDetails(note: CreateNoteDto) {
        val intent = Intent(this, NoteDetailsActivity::class.java)
        intent.putExtra("note", note)
        startActivity(intent)
    }

    override fun updateView(notesList: ArrayList<CreateNoteDto>?) {
        if (notesList.isNullOrEmpty()) {
            notesListRecyclerView.adapter=null
            Toast.makeText(this, "Notes list is empty!", Toast.LENGTH_LONG).show()
        }
        else {
            notesListAdapter = NotesListAdapter(
                    this,
                    notesList = notesList,
                    onNoteItemClick = { note -> presenter.onNoteItemClick(note) },
                    onDeleteNoteItemClick = { position -> presenter.deleteNote(position) })

            notesListRecyclerView.layoutManager = LinearLayoutManager(this)
            notesListRecyclerView.adapter = notesListAdapter
        }
    }
}
