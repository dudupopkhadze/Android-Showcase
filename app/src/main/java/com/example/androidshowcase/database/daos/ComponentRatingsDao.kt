package com.example.androidshowcase.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidshowcase.database.entities.ComponentRating

@Dao
interface ComponentRatingsDao {
    //TODO make sure this is not needed
//    @Query("select * from component_ratings")
//    fun getAllComponentRatings(): List<ComponentRating>
//
//    @Query("select * from component_ratings where id = :componentRatingId limit 1")
//    fun getComponentRating(componentRatingId: Int): ComponentRating

    @Query("select * from component_ratings cr join components c on c.name = :componentName and c.id = cr.componentId where cr.ratingId = 1")
    fun getComponentPositiveRatings(componentName: String): List<ComponentRating>

    @Query("select * from component_ratings cr join components c on c.name = :componentName and c.id = cr.componentId where cr.ratingId = 2")
    fun getComponentNegativeRatings(componentName: String): List<ComponentRating>

    @Insert
    fun insertComponentRating(componentRating: ComponentRating)

    @Delete
    fun deleteComponentRating(componentRating: ComponentRating)
}