package com.example.latihanpam8

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserdDao {
    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Insert
    fun insertUser(user: User)
}