package com.bizmiz.milliyoyinlar.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "milliy_oyinlar")
data class Entity(
    @PrimaryKey
    val id: Int?,
    @ColumnInfo(name = "nomi")
    val nomi: String?,
    @ColumnInfo(name = "qoraqalpoq")
    val qr: String?,
    @ColumnInfo(name = "uzbek")
    val uz: String?,
    @ColumnInfo(name = "rus")
    val ru: String?,
    @ColumnInfo(name = "english")
    val en: String?
)