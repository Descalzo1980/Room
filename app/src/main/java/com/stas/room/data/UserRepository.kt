package com.stas.room.data

import androidx.lifecycle.LiveData

class UserRepository(private val nameDao: UserDao) {

    val readAllName : LiveData<List<User>> = nameDao.getAllName()

    suspend fun addName(name: User){
        nameDao.addName(name)
    }

}