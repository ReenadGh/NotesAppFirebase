package com.example.noteappfirebase2

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*
import kotlin.random.Random
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ItemTouchHelper


class RecyclerViewAdapter(private val activity: MainActivity) : RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>(){
    class ItemViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView)

    private var notes = emptyList<Note>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val myNote = notes[position].noteDes
        val myNoteId = notes[position].id
        holder.itemView.apply {
            notebox.text = myNote
            notebox.setOnClickListener {
                cardViewNote.isVisible = false
                cardEditNote.isVisible = true
                editNote.setText(myNote)

                addEdit.setOnClickListener {
                    cardViewNote.isVisible = true
                    cardEditNote.isVisible = false

                    activity.myViewModel.editNote(myNoteId ,editNote.text.toString() )
                    //   notebox.text = editNote.text.toString()
                }


            }
            deleteB.setOnClickListener {
                activity.myViewModel.deleteNote(myNoteId)
            }

        }
    }

    override fun getItemCount() = notes.size

    fun update(notes: List<Note>){
        println("UPDATING DATA")
        this.notes = notes
        notifyDataSetChanged()
    }


}
