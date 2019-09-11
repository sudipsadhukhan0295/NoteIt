package com.noteit.app.data

import com.noteit.app.data.model.Note

interface NotesDataSource {

    suspend fun getNotes() : List<Note>
}