package com.example.appdesingpattern.repository

import androidx.lifecycle.MutableLiveData
import com.example.appdesingpattern.apirest.RetrofitClient
import com.example.appdesingpattern.apirest.response.PersonResult
import com.example.appdesingpattern.apirest.response.ResultsItem
import com.example.appdesingpattern.db.dao.PersonDao
import com.example.appdesingpattern.db.entity.toEntity
import com.example.appdesingpattern.domain.model.Person
import com.example.appdesingpattern.domain.model.toDomain
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonRepository(private val personDao: PersonDao) {

    var result = MutableLiveData<List<ResultsItem>>()

    suspend fun allByApi(): List<Person> {
        val call: Call<PersonResult> = RetrofitClient.retrofitService.personList()
        call.enqueue(object: Callback<PersonResult>{
            override fun onResponse(call: Call<PersonResult>, response: Response<PersonResult>) {
                result.value = response.body()!!.results
            }

            override fun onFailure(call: Call<PersonResult>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
        return result.value!!.map { it.toDomain() }
    }

    suspend fun add(person: Person) {
        personDao.add(person.toEntity())
    }

    suspend fun allByDb(): List<Person> {
        val list = personDao.all()
        if (list.isNullOrEmpty()) {
            return listOf()
        }
        return list!!.map { it.toDomain()}
    }
}