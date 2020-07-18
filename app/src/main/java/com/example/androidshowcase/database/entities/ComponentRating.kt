package com.example.androidshowcase.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "component_ratings")
data class ComponentRating(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val userId: Long,
        val componentId: Long,
        val ratingId: Long
)