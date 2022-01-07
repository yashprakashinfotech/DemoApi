package com.yash.demoapi

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.http.GET


// https://reqres.in/api/users?page=2

const val BASE_URL = "https://reqres.in/"

interface UserInterface{

    @GET("api/users?page=2")
    fun getData() : Call<DemoData>
}

object UserService{

    val userInstance: UserInterface

    init {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        userInstance = retrofit.create(UserInterface::class.java)

    }

}