package com.example.androidshowcase.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidshowcase.database.entities.ComponentMarking

@Dao
interface ComponentMarkingsDao {
    @Query("select * from component_markings")
    fun getAllComponentMarkings(): List<ComponentMarking>

    @Query("select * from component_markings where componentId= :componentId limit 1")
    fun getComponentMarkingByComponentId(componentId: Long): ComponentMarking

    @Insert
    fun insertComponentMarking(componentMarking: ComponentMarking)

    @Delete
    fun deleteComponentMarking(componentMarking: ComponentMarking)
}