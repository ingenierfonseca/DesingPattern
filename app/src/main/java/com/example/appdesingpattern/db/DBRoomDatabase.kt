package com.example.appdesingpattern.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appdesingpattern.db.dao.PersonDao
import com.example.appdesingpattern.db.entity.PersonEntity

@Database(entities = [PersonEntity::class], version = 1)
abstract class DBRoomDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao

    companion object{
        @Volatile
        private var INSTANCE: DBRoomDatabase? = null

        fun getDatabase(context: Context): DBRoomDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DBRoomDatabase::class.java,
                    "desingpatterndb"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}