package com.example.appdesingpattern.apirest.response

data class ResultsItem(val gender: String = "",
                       val species: String = "",
                       val name: String = "",
                       val id: Int = 0,
                       val type: String = "",
                       val status: String = "")