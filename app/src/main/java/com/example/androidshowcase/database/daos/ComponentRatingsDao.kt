package com.example.androidshowcase.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidshowcase.database.entities.ComponentRating
import com.example.androidshowcase.database.entities.Library

@Dao
interface ComponentRatingsDao {
    @Query("select * from component_ratings")
    fun getAllComponentRatings(): List<ComponentRating>

    @Query("select * from component_ratings where id = :componentRatingId limit 1")
    fun getLibrary(componentRatingId: Int): ComponentRating

    @Insert
    fun insertComponentRating(componentRating: ComponentRating)

    @Delete
    fun deleteLibrary(componentRating: ComponentRating)
}