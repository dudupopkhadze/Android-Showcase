package com.example.androidshowcase.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidshowcase.database.entities.ComponentRating
import com.example.androidshowcase.database.entities.LibraryRating

@Dao
interface LibraryRatingsDao {

    @Query("select * from library_ratings lr join libraries l on l.name = :libraryName and l.id = lr.libraryId where lr.ratingId = 1")
    fun getPositiveLibraryRatings(libraryName: String): List<ComponentRating>

    @Query("select * from library_ratings lr join libraries l on l.name = :libraryName and l.id = lr.libraryId where lr.ratingId = 2")
    fun getNegativeLibraryRatings(libraryName: String): List<ComponentRating>

    @Insert
    fun insertLibraryRating(libraryRating: LibraryRating)

    @Delete
    fun deleteLibraryRating(libraryRating: LibraryRating)
}