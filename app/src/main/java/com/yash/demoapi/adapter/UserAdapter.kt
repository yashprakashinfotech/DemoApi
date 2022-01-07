package com.yash.demoapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yash.demoapi.R
import com.yash.demoapi.data.Data

class UserAdapter(val context: Context, val users: ArrayList<Data>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val userdata = users[position]
        holder.firstName.text = userdata.first_name
        holder.lastName.text = userdata.last_name
        holder.userEmail.text = userdata.email
        Glide.with(context).load(userdata.avatar).into(holder.userImage)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val firstName = itemView.findViewById<TextView>(R.id.firstName)
        val lastName = itemView.findViewById<TextView>(R.id.lastName)
        val userEmail = itemView.findViewById<TextView>(R.id.userEmailId)
        val userImage = itemView.findViewById<ImageView>(R.id.userImage)
    }
}