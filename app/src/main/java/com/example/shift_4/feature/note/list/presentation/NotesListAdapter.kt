package com.example.shift_4.feature.note.list.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.common.Note
import com.example.shift_4.R
import kotlinx.android.synthetic.main.item_note.view.*

typealias OnNoteItemClick = (Note) -> Unit

class NotesListAdapter(
    private val context: Context,
    private var notesList: List<Note>,
    private val onNoteItemClick: OnNoteItemClick
) : RecyclerView.Adapter<NotesListAdapter.ViewHolder>() {

    var isLastPage: Boolean = false
    var isLoading: Boolean = false

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindNote(note: Note, onNoteItemClick: OnNoteItemClick) {
            itemView.apply {
                itemNoteTitle.text = note.title
                itemNoteDescription.text = note.description

                setOnClickListener { onNoteItemClick(note) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(view)
    }

    fun getNotesList(): List<Note> {
        return notesList
    }

    override fun getItemCount(): Int {
        return notesList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindNote(notesList[position], onNoteItemClick)
    }

    fun addData(notesList1: List<Note>?) {
        if (notesList1 != null) {
            val size = notesList.size
            notesList = listOf(notesList, notesList1).flatMap { it }
            val sizeNew = notesList.size
            notifyItemRangeChanged(size, sizeNew)
        }
    }
}