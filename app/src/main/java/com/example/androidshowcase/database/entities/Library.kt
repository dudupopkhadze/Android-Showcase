package com.example.androidshowcase.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "libraries")
data class Library(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val name: String
)