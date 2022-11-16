package com.stas.room.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Name::class], version = 1, exportSchema = false)
abstract class NameDataBase: RoomDatabase(){
    abstract fun nameDao() : NameDao

    companion object{
        @Volatile
        private var INSTANCE : NameDataBase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDataBase(context: Context) : NameDataBase {
            val base = INSTANCE
            if (base != null){
                return base
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    NameDataBase::class.java,
                    "name_table"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}