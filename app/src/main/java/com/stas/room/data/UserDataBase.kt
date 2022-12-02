package com.stas.room.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDataBase: RoomDatabase(){
    abstract fun nameDao() : UserDao

    companion object{
        @Volatile
        private var INSTANCE : UserDataBase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDataBase(context: Context) : UserDataBase {
            val base = INSTANCE
            if (base != null){
                return base
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    UserDataBase::class.java,
                    "name_table"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}