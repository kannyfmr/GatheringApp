package com.example.kannyf.anjirrapps.fragment



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kannyf.anjirrapps.R
import com.example.kannyf.anjirrapps.adapter.CountryAdapter
import com.example.kannyf.anjirrapps.model.PostData
import kotlinx.android.synthetic.main.user_list.*


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


    private fun generated(): MutableList<PostData> {
        var user = ArrayList<PostData>()

        user.add(PostData("Liverpool Paling Top","Liverpool Adalah Peraih Gelar Terbanyak" ))
        user.add(PostData("Manchester United Klub Sampah","Sampah EROPA alias Badut UCL" ))
        user.add(PostData("Barcelona Klub Wasit, Aib Spanyol","Klub tukang nyogok Wasit dan menghalalkan segala Cara" ))
        user.add(PostData("Liverpool Juara BPL Asia 2 Tahun Berturut - turut","Klub Maha Dah" ))

        return user

    }


}
