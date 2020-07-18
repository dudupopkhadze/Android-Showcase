package com.example.androidshowcase.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidshowcase.database.entities.Library

@Dao
interface LibrariesDao {
    @Query("select * from libraries")
    fun getAllLibraries(): List<Library>

    @Query("select * from libraries where id = :libraryId limit 1")
    fun getLibrary(libraryId: Int): Library

    @Insert
    fun insertLibrary(library: Library)

    @Delete
    fun deleteLibrary(library: Library)
}