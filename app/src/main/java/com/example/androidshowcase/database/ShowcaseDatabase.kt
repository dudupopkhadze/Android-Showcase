package com.example.androidshowcase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidshowcase.database.entities.*

@Database(entities = [User::class, Component::class, ComponentRating::class, Library::class, LibraryRating::class, RatingType::class], version = 1)
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

}