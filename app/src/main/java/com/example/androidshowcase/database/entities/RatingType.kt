package com.example.androidshowcase.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rating_types")
data class RatingType(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val literalValue: String
)