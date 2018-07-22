package com.example.kannyf.anjirrapps.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kannyf.anjirrapps.R
import com.example.kannyf.anjirrapps.model.PostData

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
        var PostData = items[position]
        holder.textName?.text = PostData.name
        holder.textComment?.text = PostData.comment
    }



    class ViewHolder(v : View) : RecyclerView.ViewHolder(v){
        var textName : TextView? = null
        var textComment : TextView? = null

        init {
            this.textName = v.findViewById(R.id.textName)
            this.textComment = v.findViewById(R.id.textComment)
        }
    }
}
