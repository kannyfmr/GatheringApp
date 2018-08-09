package com.example.kannyf.anjirrapps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kannyf.anjirrapps.R
import com.example.kannyf.anjirrapps.model.Category

class CategoryAdapter(private val userList : ArrayList<Category> ) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user : Category = userList[position]

        holder.textName.text = user.name
        holder.textAddress.text = user.address
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val textName = itemView.findViewById(R.id.description) as TextView
        val textAddress = itemView.findViewById(R.id.author) as TextView

    }
}