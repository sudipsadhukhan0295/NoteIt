package com.noteit.app.data.local

import androidx.room.Dao
import androidx.room.Query
import com.noteit.app.data.model.Note

@Dao
interface NotesDao {

    @Query("SELECT * FROM notes")
    suspend fun getNotes(): List<Note>
}