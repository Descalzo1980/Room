package com.stas.room.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.stas.room.data.Name

@Dao
interface NameDao {

    @Query("SELECT * FROM name_table")
    fun getAllName() : LiveData<List<Name>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addName(name: Name)

}