package com.example.shift_4.feature.note.list.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.common.Note
import com.example.shift_4.R
import com.example.shift_4.feature.note.add.presentation.AddNoteActivity
import com.example.shift_4.feature.note.details.presentation.NoteDetailsActivity
import kotlinx.android.synthetic.main.activity_notes_list.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class NotesListActivity : AppCompatActivity(), NotesListView {

    private lateinit var presenter: NotesListPresenter

    private var notesListAdapter: NotesListAdapter? = null

    private val coroutineScope = MainScope()

    private var currentNotesList:ArrayList<Note>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_list)

        coroutineScope.launch {
            presenter = NotesListPresenterImpl(this@NotesListActivity)
            presenter.onViewAttached()
        }

        addNoteButton.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        coroutineScope.launch {
            presenter = NotesListPresenterImpl(this@NotesListActivity)
            presenter.onViewAttached()
        }
        super.onResume()
    }

    override fun showNotes(notesList: ArrayList<Note>?) {
        if (notesList.isNullOrEmpty()) {
            Toast.makeText(this, "Notes list is empty!", Toast.LENGTH_LONG).show()
        } else {
            currentNotesList = notesList
            notesListAdapter = NotesListAdapter(
                this,
                notesList = notesList,
                onNoteItemClick = { note ->
                    presenter.onNoteItemClick(note)
                })

            val mLayoutManager = LinearLayoutManager(this)
            notesListRecyclerView.layoutManager = mLayoutManager


            val divider = DividerItemDecoration(
                notesListRecyclerView.context, mLayoutManager.orientation)

            ContextCompat.getDrawable(baseContext, R.drawable.divider_black)?.let { divider.setDrawable(it) }
            notesListRecyclerView.addItemDecoration(divider)

            val simpleCallback: ItemTouchHelper.SimpleCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
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
                    coroutineScope.launch {
                        val currentNotesList = notesListAdapter!!.getNotesList()
                        presenter.deleteNote(currentNotesList[position].id)
                    }
                }
            }

            val itemTouchHelper = ItemTouchHelper(simpleCallback)
            itemTouchHelper.attachToRecyclerView(notesListRecyclerView)

            notesListRecyclerView.adapter = notesListAdapter
            notesListRecyclerView?.addOnScrollListener(object : PaginationScrollListener(mLayoutManager) {

                override fun isLastPage(): Boolean {
                    return notesListAdapter!!.isLastPage
                }

                override fun isLoading(): Boolean {
                    return notesListAdapter!!.isLoading
                }

                override fun loadMoreItems(totalItemCount: Int) {
                    notesListAdapter!!.isLoading = true

                    coroutineScope.launch {
                        //val currentNotesList = notesListAdapter!!.getNotesList()
                        //val lastElId = currentNotesList.last().id
                        val lastElIndex=notesListAdapter!!.getNotesList().lastIndex
                        val newPage = presenter.getPage((lastElIndex+1).toLong(), 10)
                        notesListAdapter!!.addData(newPage)
                        notesListAdapter!!.isLoading = false
                    }
                }
            })
        }

    }

    override fun navigateToNoteDetails(note: Note) {
        val intent = Intent(this, NoteDetailsActivity::class.java)
        intent.putExtra("note", note)
        startActivity(intent)
    }

    override fun onDestroy() {
        coroutineScope.cancel()
        super.onDestroy()
    }
}
