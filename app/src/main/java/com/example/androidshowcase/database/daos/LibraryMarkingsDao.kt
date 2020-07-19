package com.example.androidshowcase.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidshowcase.database.entities.ComponentMarking
import com.example.androidshowcase.database.entities.LibraryMarking

@Dao
interface LibraryMarkingsDao {

    @Query("select * from library_markings lm join libraries l on l.name = :libraryName and l.id = lm.libraryId where lm.markingId = 1")
    fun getPositiveLibraryMarkings(libraryName: String): List<ComponentMarking>

    @Query("select * from library_markings lm join libraries l on l.name = :libraryName and l.id = lm.libraryId where lm.markingId = 2")
    fun getNegativeLibraryMarkings(libraryName: String): List<ComponentMarking>

    @Insert
    fun insertLibraryMarking(libraryMarking: LibraryMarking)

    @Delete
    fun deleteLibraryMarking(libraryMarking: LibraryMarking)
}