package com.example.androidshowcase.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidshowcase.database.entities.RatingType

@Dao
interface RatingTypesDao {
    @Query("select * from rating_types")
    fun getAllRatingTypes(): List<RatingType>

    @Query("select * from rating_types where id = :ratingTypeId limit 1")
    fun getRatingType(ratingTypeId: Int): RatingType

    @Insert
    fun insertRatingType(ratingType: RatingType)

    @Delete
    fun deleteRatingType(ratingType: RatingType)
}