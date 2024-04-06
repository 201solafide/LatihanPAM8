package com.example.latihanpam8

import android.app.Application
import androidx.room.Room

class MyApp : Application() {
    companion object{
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "my_database").build()

        // mengisi data dummy dalam database
        Thread{
            val userdDao = database.userDao()
            userdDao.insertUser(User (username = "John Smith", email = "john@example.com"))
            userdDao.insertUser(User (username = "Jane Smith", email = "jane@example.com"))
            userdDao.insertUser(User (username = "Mike Smith", email = "mike@example.com"))
        }.start()
    }
}