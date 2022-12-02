package com.stas.room.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    val readAllName : LiveData<List<User>>
    private val repository : UserRepository

    init {
        val nameDao = UserDataBase.getDataBase(application).nameDao()
        repository = UserRepository(nameDao)
        readAllName = repository.readAllName
    }

    fun addName(name: User){
        viewModelScope.launch ( Dispatchers.IO ){
            repository.addName(name)
        }
    }

}