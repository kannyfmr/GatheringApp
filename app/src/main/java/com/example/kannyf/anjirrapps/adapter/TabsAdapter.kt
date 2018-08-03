package com.example.kannyf.anjirrapps.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.kannyf.anjirrapps.fragment.CommunityFollowedFr

class TabsAdapter(fm: FragmentManager): FragmentPagerAdapter(fm){
    private val fragment: ArrayList<Fragment> = ArrayList()
    private val fragTitle: ArrayList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return fragment[position]
    }

    override fun getCount(): Int {
        return fragment.size
    }
    fun addFragment(frag: Fragment, title: String){
        fragment.add(frag)
        fragTitle.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragTitle[position]
    }
}