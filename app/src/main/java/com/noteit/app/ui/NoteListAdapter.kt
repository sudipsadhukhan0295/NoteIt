package com.noteit.app.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.noteit.app.R
import com.noteit.app.data.model.Note
import kotlinx.android.synthetic.main.activity_home_list_cardview.view.*

class NoteListAdapter(private val context: Context, private var notes: MutableList<Note>) :
    RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.activity_home_list_cardview,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_title.text = notes[position].title
        holder.itemView.tv_description.text = notes[position].description
    }


    fun setNotes(notes: List<Note>) {
        this.notes = notes as MutableList<Note>
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}