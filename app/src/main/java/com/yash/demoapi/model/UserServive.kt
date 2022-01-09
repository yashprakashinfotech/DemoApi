package com.yash.demoapi.model

import android.util.Log
import android.widget.TextView
import com.yash.demoapi.BASE_URL
import com.yash.demoapi.UserInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserService{



    val userInstance: UserInterface

    init {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        userInstance = retrofit.create(UserInterface::class.java)


        val jsonPlaceHolderApi = retrofit.create(UserInterface::class.java)

        val userSend = UserPost(1,"patelyoyo@gmail.com","yoyo","patel","string")

        val call = jsonPlaceHolderApi.postData(userSend)



        call.enqueue(object : Callback<UserPost?> {
            override fun onResponse(call: Call<UserPost?>, response: Response<UserPost?>) {
                Log.d("Ansh","Data post")
            }

            override fun onFailure(call: Call<UserPost?>, t: Throwable) {
                Log.d("PSSPL","Error in Fetching Data",t)
            }
        })

    }

}