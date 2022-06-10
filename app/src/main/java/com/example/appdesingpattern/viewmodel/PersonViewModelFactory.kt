package com.example.appdesingpattern.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PersonViewModelFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersonViewModel::class.java)) {
            return PersonViewModel(application) as T
        }
        throw IllegalArgumentException("Unknow class name")
    }
}