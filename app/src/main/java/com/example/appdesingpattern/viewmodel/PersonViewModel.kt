package com.example.appdesingpattern.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.appdesingpattern.apirest.response.ResultsItem
import com.example.appdesingpattern.repository.PersonRepository

class PersonViewModel: ViewModel() {
    private var repository = PersonRepository()

    fun personList(): LiveData<List<ResultsItem>> {
        return repository.personList()
    }
}