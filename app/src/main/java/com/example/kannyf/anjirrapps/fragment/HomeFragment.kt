package com.example.kannyf.anjirrapps.fragment



import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kannyf.anjirrapps.adapter.CountryAdapter

import com.example.kannyf.anjirrapps.R
import com.example.kannyf.anjirrapps.model.PostData


class HomeFragment : Fragment() {

    
    lateinit var recyclerView : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView = view.findViewById(R.id.country_list)
        var adapter = CountryAdapter(generated())
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()


    }

    private fun generated(): ArrayList<PostData> {
        var result = ArrayList<PostData>()

        for (i in 0..9){
            var user : PostData = PostData("Liverpool Juara BPL Hongkong", "Liverpool Menjadi Grup Terbaik di PL salah satu klub maha dahsyat")
            result.add(user)
        }
        return result
    }
}
