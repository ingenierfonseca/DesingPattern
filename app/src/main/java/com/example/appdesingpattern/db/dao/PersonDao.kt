package com.example.appdesingpattern.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.appdesingpattern.db.entity.PersonEntity

@Dao
interface PersonDao {
    @Insert
    suspend fun add(person: PersonEntity)

    @Query("SELECT * FROM PERSON ORDER BY ID ASC")
    suspend fun all(): List<PersonEntity>
}