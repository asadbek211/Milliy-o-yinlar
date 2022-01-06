package com.bizmiz.milliyoyinlar.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bizmiz.milliyoyinlar.dao.Dao
import com.bizmiz.milliyoyinlar.entity.Entity

@Database(entities = [Entity::class], version = 1)
abstract class OyinlarDatabase : RoomDatabase() {
    companion object {
        lateinit var INSTANCE: OyinlarDatabase
     fun getInstance(context: Context):OyinlarDatabase{
     if (!Companion::INSTANCE.isInitialized){
        INSTANCE = Room.databaseBuilder(
context,OyinlarDatabase::class.java,"milliy_oyinlar.db"
        ).fallbackToDestructiveMigration()
           .allowMainThreadQueries().createFromAsset("milliy_oyinlar.db")
           .build()
     }
        return INSTANCE
     }
    }
   abstract fun dao():Dao
}