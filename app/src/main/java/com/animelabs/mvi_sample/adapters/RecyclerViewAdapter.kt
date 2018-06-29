package com.animelabs.mvi_sample.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.animelabs.mvi_sample.R
import com.animelabs.mvi_sample.data.models.UserResponse
import kotlinx.android.synthetic.main.item_user.view.*

class RecyclerViewAdapter(var users: ArrayList<UserResponse>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user, parent, false ))
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val (login, score) = users.get(position)
        holder.textViewName.text = login
        holder.textViewScore.text = score?.toString()
    }

    fun clearAdapter() {
        users.clear()
        notifyDataSetChanged()
    }

    fun setData(users: ArrayList<UserResponse>) {
        this.users = users
        notifyDataSetChanged()
    }
}

class ViewHolder(view : View): RecyclerView.ViewHolder(view) {
    val textViewName = view.item_user_name
    val imageViewUser = view.item_user_image
    val textViewScore = view.item_user_score
}
