package com.example.kannyf.gajeApp.activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kannyf.gajeApp.R
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    lateinit var mProgreess : ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        register.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }
        login.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
