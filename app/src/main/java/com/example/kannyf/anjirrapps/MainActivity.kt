package com.example.kannyf.anjirrapps

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import com.example.kannyf.anjirrapps.fragment.AccountFragment
import com.example.kannyf.anjirrapps.fragment.CommunityFragment
import com.example.kannyf.anjirrapps.fragment.HomeFragment
import com.example.kannyf.anjirrapps.fragment.NotificationFragment
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
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Apakah Kamu Yakin")
        builder.setMessage("Yakin Untuk Keluar")
        builder.setPositiveButton("ya") { _: DialogInterface, i: Int -> finish() }
        builder.setNegativeButton("tidak") { _: DialogInterface, i: Int -> }
        builder.show()
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
