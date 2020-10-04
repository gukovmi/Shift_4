package com.example.shift_4.feature.note.list.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.common.Note
import com.example.shift_4.R
import com.example.shift_4.feature.note.add.presentation.AddNoteActivity
import com.example.shift_4.feature.note.details.presentation.NoteDetailsActivity
import kotlinx.android.synthetic.main.activity_notes_list.*

class NotesListActivity : AppCompatActivity(), NotesListView {

    private val presenter = NotesListPresenterImpl()

    private lateinit var notesListAdapter: NotesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_list)

        presenter.attachView(this)

        presenter.onViewAttached()
    }

    override fun onResume() {
        presenter.initConfigure()
        super.onResume()
    }

    override fun navigateToNoteDetails(note: Note) {
        val intent = Intent(this, NoteDetailsActivity::class.java)
        intent.putExtra("note", note)
        startActivity(intent)
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun addPageToAdapter(newPage: List<Note>) {
        notesListAdapter.addData(newPage)
        notesListAdapter.isLoading = false
    }

    override fun initConfigure(notesList: List<Note>) {
        notesListAdapter = NotesListAdapter(
            this,
            notesList = notesList,
            onNoteItemClick = { note ->
                presenter.onNoteItemClick(note)
            })

        notesListRecyclerView.layoutManager = LinearLayoutManager(this)
        notesListRecyclerView.adapter = notesListAdapter


        val simpleCallback: ItemTouchHelper.SimpleCallback =
            object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    viewHolder1: RecyclerView.ViewHolder
                ): Boolean {
                    return true
                }

                override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
                    Toast.makeText(this@NotesListActivity, "Swipe left to delete", Toast.LENGTH_SHORT).show()
                    super.onSelectedChanged(viewHolder, actionState)
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, i: Int) {
                    Toast.makeText(this@NotesListActivity, "Note has been deleted", Toast.LENGTH_SHORT).show()
                    val position = viewHolder.adapterPosition
                    val currentNotesList = notesListAdapter.getNotesList()
                    Log.e("Position", position.toString())
                    presenter.deleteNote(currentNotesList[position].id)

                }
            }

        val itemTouchHelper = ItemTouchHelper(simpleCallback)
        itemTouchHelper.attachToRecyclerView(notesListRecyclerView)

        notesListRecyclerView?.addOnScrollListener(object :
            PaginationScrollListener(notesListRecyclerView.layoutManager as LinearLayoutManager) {

            override fun isLastPage(): Boolean {
                return notesListAdapter.isLastPage
            }

            override fun isLoading(): Boolean {
                return notesListAdapter.isLoading
            }

            override fun loadMoreItems(totalItemCount: Int) {
                notesListAdapter.isLoading = true
                val lastElIndex = notesListAdapter.getNotesList().lastIndex
                Log.e("lastElIndex", lastElIndex.toString())
                presenter.getPage((lastElIndex + 1).toLong(), 10)
            }
        })

        addNoteButton.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }

        updateNotesListButton.setOnClickListener {
            presenter.initConfigure()
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}
