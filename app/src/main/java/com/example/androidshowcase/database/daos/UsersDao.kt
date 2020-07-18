package com.example.androidshowcase.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.androidshowcase.database.entities.User

@Dao
interface UsersDao {
    @Query("select * from users")
    fun getAllUsers(): List<User>

    @Query("select * from users where id = :userId limit 1")
    fun getUser(userId: Int): User

    @Insert
    fun insertUser(user: User)

    @Delete
    fun deleteUser(users: User)
}