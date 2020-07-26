package com.example.androidshowcase.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidshowcase.database.entities.LibraryMarking
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue

@Dao
interface LibraryMarkingsDao {

    @Query("select * from library_markings")
    fun getAllLibraryMarkings(): List<LibraryMarking>

    @Query("select * from library_markings where libraryId = :libraryId limit 1")
    fun getLibraryMarkingByLibraryId(libraryId: Long): LibraryMarking

    @Query("delete from library_markings")
    fun deleteAllValues()

    @Insert
    fun insertLibraryMarking(libraryMarking: LibraryMarking)

    @Delete
    fun deleteLibraryMarking(libraryMarking: LibraryMarking)
}