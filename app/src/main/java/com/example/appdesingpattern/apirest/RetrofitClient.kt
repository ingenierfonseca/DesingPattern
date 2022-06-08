package com.example.appdesingpattern.apirest

import com.example.appdesingpattern.apirest.service.PersonService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {
    private fun builderRetrofit() = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService: PersonService by lazy {
        builderRetrofit().create(PersonService::class.java)
    }
}