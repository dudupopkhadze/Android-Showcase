package com.example.androidshowcase.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidshowcase.database.entities.*

@Database(entities = [User::class, Component::class, ComponentRating::class, Library::class, LibraryRating::class, RatingType::class], version = 1)
abstract class ShowcaseDatabase : RoomDatabase() {

}