package com.example.kannyf.anjirrapps

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import com.example.kannyf.anjirrapps.fragment.AccountFragment
import com.example.kannyf.anjirrapps.fragment.CommunityFragment
import com.example.kannyf.anjirrapps.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val manager = supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                buatFragmentsatu()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {

                buatFragmentdua()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                buatFragmenttiga()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buatFragmentsatu()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun buatFragmentsatu() {
        val transaction = manager.beginTransaction()
        val fragment = HomeFragment()
        transaction.replace(R.id.fragmentholder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun buatFragmentdua() {
        val transaction = manager.beginTransaction()
        val fragment = CommunityFragment()
        transaction.replace(R.id.fragmentholder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun buatFragmenttiga() {
        val transaction = manager.beginTransaction()
        val fragment = AccountFragment()
        transaction.replace(R.id.fragmentholder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
