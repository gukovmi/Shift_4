package com.example.shift_4.feature.note.list.presentation

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.common.Note
import com.example.shift_4.R
import kotlinx.android.synthetic.main.item_note.view.*

typealias OnNoteItemClick = (Note) -> Unit
typealias OnDeleteNote = (Long) -> Unit

class NotesListAdapter (
    private val context: Context,
    private val notesList: ArrayList<Note>,
    private val onNoteItemClick: OnNoteItemClick
) : RecyclerView.Adapter<NotesListAdapter.ViewHolder>()
{

    var isLastPage: Boolean = false
    var isLoading: Boolean = false

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindNote(note: Note, noteId: Long, onNoteItemClick: OnNoteItemClick) {
            itemView.apply {
                itemNoteTitle.text=note.title
                itemNoteDescription.text=note.description

                setOnClickListener { onNoteItemClick(note) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(view)
    }

    fun getNotesList(): ArrayList<Note> {
        return notesList
    }

    override fun getItemCount(): Int {
        return notesList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindNote(notesList[position], notesList[position].id, onNoteItemClick)
    }

    fun addData(notesList1: ArrayList<Note>?) {
        if(notesList1!=null) {
            val size = notesList.size
            notesList.addAll(notesList1)
            val sizeNew = notesList.size
            notifyItemRangeChanged(size, sizeNew)
        }
    }
}