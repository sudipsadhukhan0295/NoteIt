package com.noteit.app.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
        @PrimaryKey
        @ColumnInfo(name = "id")
        var noteId: Int,
        var title: String = "",
        var description: String = ""
)