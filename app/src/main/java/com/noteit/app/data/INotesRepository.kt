package com.noteit.app.data

import com.noteit.app.data.model.Note

interface INotesRepository {

    suspend fun getNotes(): Result<List<Note>>

    suspend fun insertNote(note: Note)
}