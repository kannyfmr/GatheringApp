package com.example.kannyf.gajeApp.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kannyf.gajeApp.R
import com.example.kannyf.gajeApp.model.PostData

class CountryAdapter(var items: MutableList<PostData>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.user_list, parent, false)
        return ViewHolder(itemView)

    }


    override fun getItemCount(): Int {
        return items.size
        //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(items[position])
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: PostData) {
            val listTitle = itemView.findViewById(R.id.textName) as TextView
            val listDesc  = itemView.findViewById(R.id.textComment) as TextView
            val listImage  = itemView.findViewById(R.id.imageView) as ImageView

            listTitle.text = user.name
            listDesc.text = user.comment
            listImage.setImageResource(user.image)
        }
    }
}
