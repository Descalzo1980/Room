package com.stas.room.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NameViewModel(application: Application) : AndroidViewModel(application) {

    private val readAllName : LiveData<List<Name>>
    private val repository : NameRepository

    init {
        val nameDao = NameDataBase.getDataBase(application).nameDao()
        repository = NameRepository(nameDao)
        readAllName = repository.readAllName
    }

    fun addName(name: Name){
        viewModelScope.launch ( Dispatchers.IO ){
            repository.addName(name)
        }
    }

}