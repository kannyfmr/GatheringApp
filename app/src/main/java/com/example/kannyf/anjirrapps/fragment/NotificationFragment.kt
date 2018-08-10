package com.example.kannyf.anjirrapps.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kannyf.anjirrapps.R
import com.example.kannyf.anjirrapps.adapter.NotifAdapter
import com.example.kannyf.anjirrapps.model.NotifModel


class NotificationFragment : Fragment() {

    lateinit var recyclerview : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragmentyc
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerview = view.findViewById(R.id.notifData)
        recyclerview.layoutManager = LinearLayoutManager(context)

        val notif = ArrayList<NotifModel>()

        notif.add(NotifModel("kannyfmr", "like your post"))

        notif.add(NotifModel("kannyfmr", "like your post"))

        notif.add(NotifModel("kannyfmr", "like your post"))

        notif.add(NotifModel("kannyfmr", "like your post"))

        notif.add(NotifModel("kannyfmr", "like your post"))

        notif.add(NotifModel("kannyfmr", "like your post"))

        val adapter = NotifAdapter(notif)
        recyclerview.adapter = adapter
    }
}