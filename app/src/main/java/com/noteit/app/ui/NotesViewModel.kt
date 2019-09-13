package com.noteit.app.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noteit.app.data.NotesRepository
import com.noteit.app.data.Result
import com.noteit.app.data.model.Note
import kotlinx.coroutines.launch

class NotesViewModel(private val notesRepository: NotesRepository) : ViewModel() {

    private val _note = MutableLiveData<Note>()
    val note: LiveData<Note> = _note

    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>> = _notes


    fun getNotes() {
        viewModelScope.launch {
            notesRepository.getNotes().let { result ->
                if (result is Result.Success) {
                    _notes.value = result.data
                }

            }
        }
    }

    fun insertNote(note: Note){
        viewModelScope.launch {
            notesRepository.insertNote(note)
        }
    }
}