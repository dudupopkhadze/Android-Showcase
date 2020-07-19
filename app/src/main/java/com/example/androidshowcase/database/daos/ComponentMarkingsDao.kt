package com.example.androidshowcase.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidshowcase.database.entities.ComponentMarking

@Dao
interface ComponentMarkingsDao {
    @Query("select cm.* from component_markings cm join components c on c.name = :componentName and c.id = cm.componentId where cm.markingId = 1")
    fun getComponentPositiveMarkings(componentName: String): List<ComponentMarking>

    @Query("select cm.* from component_Markings cm join components c on c.name = :componentName and c.id = cm.componentId where cm.markingId = 2")
    fun getComponentNegativeMarkings(componentName: String): List<ComponentMarking>

    @Insert
    fun insertComponentMarking(componentMarking: ComponentMarking)

    @Delete
    fun deleteComponentMarking(componentMarking: ComponentMarking)
}