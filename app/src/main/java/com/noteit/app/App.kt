package com.noteit.app

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.noteit.app.data.NotesDataSource
import com.noteit.app.data.NotesRepository
import com.noteit.app.data.local.AppDatabase
import com.noteit.app.utils.DATABASE_NAME

class App : Application() {

    private var database: AppDatabase? = null

    val notesRepository: NotesRepository
        get() = provideNotesRepository(this)

    override fun onCreate() {
        super.onCreate()
    }

    private fun provideNotesRepository(context: Context): NotesRepository {
        synchronized(this) {
            return createNotesRepository(context)
        }
    }

    private fun createNotesRepository(context: Context): NotesRepository {
        return NotesRepository(createNotesDataSource(context))
    }

    private fun createNotesDataSource(context: Context): NotesDataSource {
        val database = database ?: createDatabase(context)
        return NotesDataSource(database.notesDao())
    }

    private fun createDatabase(context: Context):AppDatabase{
        val result = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, DATABASE_NAME
        ).build()
        database = result
        return result
    }
}