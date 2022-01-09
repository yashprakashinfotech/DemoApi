package com.yash.demoapi

import com.yash.demoapi.data.DemoData
import com.yash.demoapi.model.UserPost
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body

import retrofit2.http.GET
import retrofit2.http.POST


// https://reqres.in/api/users?page=2


// https://reqres.in/api/users

const val BASE_URL = "https://reqres.in/api/"

interface UserInterface{

    @GET("users?page=2")
    fun getData() : Call<DemoData>

    @POST("users")
    fun postData(
       @Body userPost: UserPost
    ): Call<UserPost>
}

