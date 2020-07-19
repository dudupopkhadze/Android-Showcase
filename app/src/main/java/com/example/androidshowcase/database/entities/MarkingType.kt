package com.example.androidshowcase.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "marking_types")
data class MarkingType(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val literalValue: String
)