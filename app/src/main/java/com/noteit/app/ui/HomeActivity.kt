package com.noteit.app.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.noteit.app.App
import com.noteit.app.R
import com.noteit.app.data.model.Note
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home_list.*

class HomeActivity : AppCompatActivity() {

    private lateinit var adapter: NoteListAdapter
    override fun onResume() {
        super.onResume()
        viewModel.getNotes()
    }

    private val notesObserver = Observer<List<Note>> {
            adapter.setNotes(it)
    }

    private lateinit var viewModel: NotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel = ViewModelProviders.of(this, ViewModelFactory((applicationContext as App).
            notesRepository)).get(NotesViewModel::class.java)
        adapter = NoteListAdapter(this, mutableListOf())

        rv_notes.adapter = adapter
        rv_notes.layoutManager =LinearLayoutManager(this)

        viewModel.notes.observe(this,notesObserver)
        viewModel.getNotes()
        fab.setOnClickListener {
            startActivity(Intent(this,CreateNoteActivity::class.java))
        }

    }


}
