package com.noteit.app.data

import com.noteit.app.data.model.Note
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NotesRepository(
    private val notesDataSource: INotesDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : INotesRepository {

    override suspend fun getNotes(): Result<List<Note>> {
        return withContext(ioDispatcher) {
            val notes = notesDataSource.getNotes()
            (notes as? Result.Success)?.data?.let { note ->
                return@withContext Result.Success(note.sortedBy { it.noteId })
            }
            return@withContext Result.Error(Exception("Illegal state"))
        }
    }

    override suspend fun insertNote(note: Note) {
        withContext(ioDispatcher) {
            notesDataSource.insertNote(note)
        }
    }


}