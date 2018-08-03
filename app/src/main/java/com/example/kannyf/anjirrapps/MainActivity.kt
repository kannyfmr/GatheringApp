package com.example.kannyf.anjirrapps

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.kannyf.anjirrapps.fragment.AccountFragment
import com.example.kannyf.anjirrapps.fragment.CommunityFragment
import com.example.kannyf.anjirrapps.fragment.HomeFragment
import com.example.kannyf.anjirrapps.fragment.NotificationFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    val manager = supportFragmentManager


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                buatFragmentsatu()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_communities -> {

                buatFragmentdua()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                buatFragmenttiga()
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_account -> {
                buatFragmentempat()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.labelVisibilityMode= LabelVisibilityMode.LABEL_VISIBILITY_LABELED


        buatFragmentsatu()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.search_menu, menu)
        val searchItem = menu?.findItem(R.id.menu_search)

        if (searchItem != null){
            val searchView = searchItem.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return true
                }
            })
        }

        return super.onCreateOptionsMenu(menu)
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
        val fragment = TabCommunity()
        transaction.replace(R.id.fragmentholder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    private fun buatFragmenttiga() {
        val transaction = manager.beginTransaction()
        val fragment = NotificationFragment()
        transaction.replace(R.id.fragmentholder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    private fun buatFragmentempat() {
        val transaction = manager.beginTransaction()
        val fragment = AccountFragment()
        transaction.replace(R.id.fragmentholder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }
}
