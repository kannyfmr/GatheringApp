package com.example.kannyf.anjirrapps.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kannyf.anjirrapps.R
import com.example.kannyf.anjirrapps.adapter.TabsAdapter
import kotlinx.android.synthetic.main.tab_community.*

class TabCommunity : Fragment() {
    private lateinit var tabsAdapter: TabsAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tabsAdapter = TabsAdapter(childFragmentManager)
        tabsAdapter.addFragment(CommunityFragment(), "Community")
        tabsAdapter.addFragment(CommunityFollowedFr(), "Followed")
        viewPager.adapter = tabsAdapter
        tabs.setupWithViewPager(viewPager)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tab_community, container, false)
    }
}
