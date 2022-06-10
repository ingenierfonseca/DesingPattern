package com.example.appdesingpattern.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appdesingpattern.db.DBRoomDatabase
import com.example.appdesingpattern.domain.model.Person
import com.example.appdesingpattern.repository.PersonRepository
import kotlinx.coroutines.launch

class PersonViewModel(application: Application): ViewModel() {
    private val repository: PersonRepository
    init {
        val personDao = DBRoomDatabase.getDatabase(application)
            .personDao()
        repository = PersonRepository(personDao)
    }

    val listPerson = MutableLiveData<List<Person>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            listPerson.value = repository.allByDb()
            isLoading.postValue(false)
        }
    }

    fun add(person: Person) {
        viewModelScope.launch {
            isLoading.postValue(true)
            repository.add(person)
            isLoading.postValue(false)
            onCreate()
        }
    }
}