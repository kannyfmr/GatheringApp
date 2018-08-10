package com.example.kannyf.anjirrapps.activities

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.example.kannyf.anjirrapps.R
import com.example.kannyf.anjirrapps.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var bottomNavigation : BottomNavigationBar
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

        //navigation.labelVisibilityMode= LabelVisibilityMode.LABEL_VISIBILITY_LABELED

        bottomNavigation = findViewById(R.id.navigation)
        bottomNavigation.setMode(BottomNavigationBar.MODE_FIXED)
        bottomNavigation.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
        bottomNavigation.isAutoHideEnabled

        bottomNavigation
                .addItem(BottomNavigationItem(R.drawable.ic_home_black_24dp, "Home").setActiveColorResource(R.color.orange))
                .addItem(BottomNavigationItem(R.drawable.ic_email_black_24dp, "Komunitas").setActiveColorResource(R.color.merah))
                .addItem(BottomNavigationItem(R.drawable.ic_notifications_black_24dp, "Notif").setActiveColorResource(R.color.hijau))
                .addItem(BottomNavigationItem(R.drawable.ic_face_black_24dp, "Akun").setActiveColorResource(R.color.kuning))
                .initialise()

        buatFragmentsatu()
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
