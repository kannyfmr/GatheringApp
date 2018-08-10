package com.example.kannyf.anjirrapps.fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kannyf.anjirrapps.R
import com.example.kannyf.anjirrapps.activities.CategoryActivity
import kotlinx.android.synthetic.main.fragment_community.*


class CommunityFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        car.setOnClickListener {
            val intent = Intent(activity, CategoryActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_community, container, false)


    }
}
