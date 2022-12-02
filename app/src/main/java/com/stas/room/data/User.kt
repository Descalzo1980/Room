package com.stas.room.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "name_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var firstName: String,
    val lastName: String,
    val age: Int
)