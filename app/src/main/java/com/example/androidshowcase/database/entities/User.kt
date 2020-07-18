package com.example.androidshowcase.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class User(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0
)