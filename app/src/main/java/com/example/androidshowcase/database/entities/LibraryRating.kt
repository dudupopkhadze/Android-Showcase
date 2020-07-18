package com.example.androidshowcase.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "library_ratings")
data class LibraryRating(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val userId: Long,
        val libraryId: Long,
        val ratingId: Long
)