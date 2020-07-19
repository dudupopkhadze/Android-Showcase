package com.example.androidshowcase.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidshowcase.database.entities.MarkingType

@Dao
interface MarkingTypesDao {
    @Query("select * from marking_types")
    fun getAllMarkingTypes(): List<MarkingType>

    @Query("select * from marking_types where id = :MarkingTypeId limit 1")
    fun getMarkingType(MarkingTypeId: Int): MarkingType

    @Query("select 1 from marking_types where literalValue = :markingLiteralValue limit 1")
    fun markingExists(markingLiteralValue: String): Boolean

    @Insert
    fun insertMarkingType(MarkingType: MarkingType)

    @Delete
    fun deleteMarkingType(MarkingType: MarkingType)
}