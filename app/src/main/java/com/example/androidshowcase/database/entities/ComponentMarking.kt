package com.example.androidshowcase.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "component_markings")
data class ComponentMarking(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val componentId: Long,
        val markingId: Long
)