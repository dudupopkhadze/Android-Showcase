package com.example.androidshowcase.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "components")
data class Component(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val name: String,
        val libraryId : Long
)