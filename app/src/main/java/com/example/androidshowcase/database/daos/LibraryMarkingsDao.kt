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

    @Query("select lm.* from library_markings lm join libraries l on l.name = :libraryName and  l.id = lm.libraryId where lm.markingId = 1")
    fun getPositiveLibraryMarkings(libraryName: String): List<LibraryMarking>

    @Query("select lm.* from library_markings lm join libraries l on l.name = :libraryName and l.id = lm.libraryId where lm.markingId = 2")
    fun getNegativeLibraryMarkings(libraryName: String): List<LibraryMarking>

    @Query("select * from library_markings where libraryId = :libraryId limit 1")
    fun getAllLibraryMarkingByLibraryId(libraryId: Long): LibraryMarking

    @Query("delete from library_markings")
    fun deleteAllValues()

    @Insert
    fun insertLibraryMarking(libraryMarking: LibraryMarking)

    @Delete
    fun deleteLibraryMarking(libraryMarking: LibraryMarking)
}