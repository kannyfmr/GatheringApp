package com.example.kannyf.anjirrapps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kannyf.anjirrapps.R
import com.example.kannyf.anjirrapps.model.NotifModel

class NotifAdapter (val notifList: List<NotifModel>) : RecyclerView.Adapter<NotifAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.fragment_notification_data, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return notifList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val notif : NotifModel = notifList[position]
        holder.notifName.text = notif.name
        holder.notifAction.text = notif.notifAksi
    }

    class ViewHolder(v : View) : RecyclerView.ViewHolder(v) {
        val notifName = v.findViewById<TextView>(R.id.notifPerson)
        val notifAction = v.findViewById<TextView>(R.id.notifAction)

    }

}