package com.noteit.app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.noteit.app.data.NotesRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val notesRepository: NotesRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(NotesViewModel::class.java) ->
                    NotesViewModel(notesRepository)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}