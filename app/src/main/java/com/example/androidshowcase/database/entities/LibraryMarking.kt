package com.example.androidshowcase.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "library_markings")
data class LibraryMarking(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val libraryId: Long,
        val markingId: Long
)