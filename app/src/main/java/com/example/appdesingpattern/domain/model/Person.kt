package com.example.appdesingpattern.domain.model

import com.example.appdesingpattern.apirest.response.ResultsItem
import com.example.appdesingpattern.db.entity.PersonEntity

data class Person(
    val name: String,
    val gender: String
)

fun PersonEntity.toDomain() = Person(name, gender)
fun ResultsItem.toDomain() = Person(name, gender)
