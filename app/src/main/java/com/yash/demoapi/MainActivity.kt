package com.yash.demoapi


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yash.demoapi.adapter.UserAdapter
import com.yash.demoapi.data.Data
import com.yash.demoapi.data.DemoData
import com.yash.demoapi.model.UserPost
import com.yash.demoapi.model.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        getUser()

//        postUser()

    }

//    private fun postUser() {
//
//
//
//        val userSend = UserPost(1,"patelyoyo@gmail.com","yoyo","patel","string")
//        val userPost = UserService.userInstance.postData(userSend)
//        val call = jsonPlaceHolderApi.postData(userSend)
//
//    }

    private fun getUser() {

        val users = UserService.userInstance.getData()
        users.enqueue(object : Callback<DemoData?> {
            override fun onFailure(call: Call<DemoData?>, t: Throwable) {
                Log.d("Prakash","Error in Fetching Data",t)
            }
            override fun onResponse(call: Call<DemoData?>, response: Response<DemoData?>) {
                val user1 = response.body()

                if (user1!=null){
                    Log.d("Prakash",user1.toString())
                    adapter = UserAdapter(this@MainActivity, user1.data as ArrayList<Data>)
                    recyclerView.adapter= adapter
                    recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
                }
            }
        })



    }
}



