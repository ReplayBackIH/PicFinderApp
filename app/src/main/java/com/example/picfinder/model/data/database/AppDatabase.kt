package com.example.picfinder.model.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ImageEntity::class],version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val dao : ImageDao

    companion object{
        fun createDatabase(context : Context) : AppDatabase{
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "mainDataBase"
            ).build()
        }
    }
}