package com.example.androidshowcase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidshowcase.data.libraries
import com.example.androidshowcase.data.markings
import com.example.androidshowcase.database.daos.*
import com.example.androidshowcase.database.entities.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [Component::class, ComponentMarking::class, Library::class, LibraryMarking::class, MarkingType::class], version = 1)
abstract class ShowcaseDatabase : RoomDatabase() {
    companion object {
        private lateinit var showcaseDatabase: ShowcaseDatabase
        var initialized: Boolean = false

        private fun fillUpDatabase() {
            val componentsDao = showcaseDatabase.getComponentsDao()
            val librariesDao = showcaseDatabase.getLibrariesDao()
            val markingsDao = showcaseDatabase.getMarkingTypesDao()
            //FILLS MARKING TYPES
            for (marking in markings) {
                GlobalScope.launch {
                    if (!markingsDao.markingExists(marking)) {
                        markingsDao.insertMarkingType(MarkingType(0, marking))
                    }
                }
            }
            //FILLS LIBRARIES AND COMPONENTS
            for (library in libraries.keys) {
                GlobalScope.launch {
                    if (!librariesDao.libraryExists(library)) {
                        librariesDao.insertLibrary(Library(0, library))
                    }
                }
                val components: List<String>? = libraries[library]
                if (components != null) {
                    for (component in components) {
                        GlobalScope.launch {
                            if (!componentsDao.componentExists(component)) {
                                componentsDao.insertComponent(Component(0, component, librariesDao.getLibraryByName(library).id))
                            }
                        }
                    }
                }

            }
        }

        fun getInstance(context: Context): ShowcaseDatabase {
            synchronized(this) {
                if (!initialized) {
                    showcaseDatabase = Room.databaseBuilder(context, ShowcaseDatabase::class.java, "showcase_database")
                            .fallbackToDestructiveMigration()
                            .build()
                    initialized = true
                    fillUpDatabase()
                }
                return showcaseDatabase
            }
        }
    }

    abstract fun getComponentsDao(): ComponentsDao
    abstract fun getLibrariesDao(): LibrariesDao
    abstract fun getLibraryMarkingsDao(): LibraryMarkingsDao
    abstract fun getComponentMarkingsDao(): ComponentMarkingsDao
    abstract fun getMarkingTypesDao(): MarkingTypesDao
}