package com.yash.demoapi

import com.yash.demoapi.data.DemoData
import com.yash.demoapi.model.UserPost
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
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

object UserService{

    val userInstance: UserInterface

    init {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        userInstance = retrofit.create(UserInterface::class.java)

//        val jsonPlaceHolderApi = retrofit.create()

    }



}