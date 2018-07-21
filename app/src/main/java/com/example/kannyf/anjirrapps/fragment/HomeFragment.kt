package com.example.kannyf.anjirrapps.fragment


import android.content.ClipData
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.kannyf.anjirrapps.R
import kotlinx.android.synthetic.main.country_child.view.*


class HomeFragment : Fragment() {

    lateinit var countrylist : RecyclerView
    var countries : MutableList<String> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adapter = CountryAdapter(countries, activity as Context)
        countrylist = view.findViewById(R.id.country_list)
        countrylist.layoutManager = LinearLayoutManager(context)
        countrylist.adapter = adapter
        loadData()
    }

    class CountryAdapter(items : List<String>,ctx: Context) : RecyclerView.Adapter<CountryAdapter.ViewHolder>(){

        var list = items
        var context = ctx

        override fun getItemCount(): Int {
            return list.size
            //To change body of created functions use File | Settings | File Templates.
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.name.text = list[position]
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.country_child, parent, false))
        }



        class ViewHolder(v : View) : RecyclerView.ViewHolder(v){
            val name = v.country_name!!
        }
    }

    fun loadData(){
        countries.add("india")
        countries.add("United States")
        countries.add("indonesia")
        countries.add("Uganda")
        countries.add("india")
        countries.add("United States")
        countries.add("indonesia")
        countries.add("Uganda")
        countries.add("india")
        countries.add("United States")
        countries.add("indonesia")
        countries.add("Uganda")
        countries.add("india")
        countries.add("United States")
        countries.add("indonesia")
        countries.add("Uganda")
        countries.add("india")
        countries.add("United States")
        countries.add("indonesia")
        countries.add("Uganda")
        countries.add("india")
        countries.add("United States")
        countries.add("indonesia")
        countries.add("Uganda")
        countries.add("india")
        countries.add("United States")
        countries.add("indonesia")
        countries.add("Uganda")
        countries.add("india")
        countries.add("United States")
        countries.add("indonesia")
        countries.add("Uganda")


    }
}
