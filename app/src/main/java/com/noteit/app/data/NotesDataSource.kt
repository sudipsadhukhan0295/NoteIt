package com.noteit.app.data

import com.noteit.app.data.local.NotesDao
import com.noteit.app.data.model.Note
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class NotesDataSource internal constructor(
    private val notesDao: NotesDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : INotesDataSource {
    override suspend fun insertNote(note: Note) {
        try {
            Result.Success(notesDao.insert(note))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun getNotes(): Result<List<Note>> = withContext(ioDispatcher) {
        return@withContext try {
            Result.Success(notesDao.getNotes())
        } catch (e: Exception) {
            Result.Error(e)
        }
    }


}