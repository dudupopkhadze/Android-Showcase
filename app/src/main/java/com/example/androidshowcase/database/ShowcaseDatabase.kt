package com.example.androidshowcase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidshowcase.database.daos.ComponentMarkingsDao
import com.example.androidshowcase.database.daos.ComponentsDao
import com.example.androidshowcase.database.daos.LibrariesDao
import com.example.androidshowcase.database.daos.LibraryMarkingsDao
import com.example.androidshowcase.database.entities.*

@Database(entities = [Component::class, ComponentMarking::class, Library::class, LibraryMarking::class, MarkingType::class], version = 1)
abstract class ShowcaseDatabase : RoomDatabase() {
    companion object {
        var showcaseDatabase: ShowcaseDatabase? = null
        fun getInstance(context: Context): ShowcaseDatabase? {
            synchronized(this) {
                if (showcaseDatabase == null) {
                    showcaseDatabase = Room.databaseBuilder(context, ShowcaseDatabase::class.java, "showcase_database")
                            .fallbackToDestructiveMigration()
                            .build()
                }
                return showcaseDatabase
            }
        }
    }

    abstract fun getComponentsDao(): ComponentsDao
    abstract fun getLibrariesDao(): LibrariesDao
    abstract fun getLibraryMarkingsDao(): LibraryMarkingsDao
    abstract fun getComponentMarkingsDao(): ComponentMarkingsDao
    abstract fun getMarkingTypesDao(): ComponentsDao
}