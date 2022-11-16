package com.stas.room.data

import androidx.lifecycle.LiveData
import com.stas.room.data.Name
import com.stas.room.data.NameDao

class NameRepository(private val nameDao: NameDao) {

    val readAllName : LiveData<List<Name>> = nameDao.getAllName()

    suspend fun addName(name: Name){
        nameDao.addName(name)
    }

}