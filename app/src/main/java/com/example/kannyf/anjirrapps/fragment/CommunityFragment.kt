package com.example.kannyf.anjirrapps.fragment


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.kannyf.anjirrapps.R


class CommunityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_community, container, false)
    }
}
