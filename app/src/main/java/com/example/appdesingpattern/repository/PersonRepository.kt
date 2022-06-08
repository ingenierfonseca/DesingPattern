package com.example.appdesingpattern.repository

import androidx.lifecycle.MutableLiveData
import com.example.appdesingpattern.apirest.RetrofitClient
import com.example.appdesingpattern.apirest.response.PersonResult
import com.example.appdesingpattern.apirest.response.ResultsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonRepository {
    var result = MutableLiveData<List<ResultsItem>>()

    fun personList(): MutableLiveData<List<ResultsItem>> {
        val call: Call<PersonResult> = RetrofitClient.retrofitService.personList()
        call.enqueue(object: Callback<PersonResult>{
            override fun onResponse(call: Call<PersonResult>, response: Response<PersonResult>) {
                result.value = response.body()!!.results
            }

            override fun onFailure(call: Call<PersonResult>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
        return result
    }
}