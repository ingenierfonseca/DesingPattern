package com.example.appdesingpattern.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appdesingpattern.domain.model.Person

@Entity(tableName = "person")
data class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val gender: String
)

fun Person.toEntity() = PersonEntity(name = name, gender = gender)