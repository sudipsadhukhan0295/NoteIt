package com.noteit.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.noteit.app.App
import com.noteit.app.R
import com.noteit.app.data.model.Note
import kotlinx.android.synthetic.main.activity_create_note.*
import kotlinx.android.synthetic.main.activity_home_list_cardview.*

class CreateNoteActivity : AppCompatActivity() {

    private lateinit var viewModel: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)
        viewModel = ViewModelProviders.of(this, ViewModelFactory((applicationContext as App).
            notesRepository)).get(NotesViewModel::class.java)

        btn_save.setOnClickListener {
            val note = Note(null,et_title.text?.toString()!!,et_description.text?.toString()!!)
            viewModel.insertNote(note)
            finish()
        }
    }
}
