package com.example.androidshowcase.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidshowcase.database.entities.Component

@Dao
interface ComponentsDao {

    @Query("select c.* from components c join libraries l on l.id = c.libraryId where l.name = :libraryName")
    fun getComponentsByLibraryName(libraryName: String): List<Component>

    @Query("select * from components")
    fun getAllComponents(): List<Component>

    @Query("select * from components where id = :componentId limit 1")
    fun getComponent(componentId: Int): Component

    @Query("select 1 from components where name = :componentName limit 1")
    fun componentExists(componentName: String): Boolean

    @Insert
    fun insertComponent(component: Component)

    @Delete
    fun deleteComponent(component: Component)
}