package com.bizmiz.milliyoyinlar.dao

import androidx.room.Dao
import androidx.room.Query
import com.bizmiz.milliyoyinlar.entity.Entity

@Dao
interface Dao {
    @Query("SELECT * FROM milliy_oyinlar  WHERE id=:id")
    fun getId(id:Int):Entity
}