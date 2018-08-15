package com.example.kannyf.anjirrapps.activities

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kannyf.anjirrapps.R
import com.example.kannyf.anjirrapps.api.LoginResponse
import com.example.kannyf.anjirrapps.api.RetrofitClient
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Login : AppCompatActivity() {

    lateinit var editEmail: EditText
    lateinit var editPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editEmail = findViewById(R.id.email)
        editPassword = findViewById(R.id.password)

        tv_register.setOnClickListener { startActivity(Intent(this, Register::class.java)) }
        login.setOnClickListener {startActivity(Intent(this@Login, MainActivity::class.java))}


    }
    private fun userLogin() {

        val username = editEmail.text.toString().trim()
        val password = editPassword.text.toString().trim()

        //authentication

        if (username.isEmpty()) {
            editEmail.error = "email is required"
            editEmail.requestFocus()
            return
        }

        if (password.isEmpty()) {
            editPassword.error = "password is required"
            editPassword.requestFocus()
            return
        }

        val dialog: android.app.AlertDialog? = SpotsDialog.Builder().setContext(this).setMessage(R.string.logging).build()
        dialog?.show()

        val call = RetrofitClient
                .instance
                .api
                .loginUser(username,password)

        call.enqueue(object : Callback<LoginResponse>
        {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                 val loginResponse : LoginResponse = response.body()!!
                if (loginResponse.isError()){
                    Toast.makeText(this@Login, loginResponse.getMessage(), Toast.LENGTH_LONG).show()
                    val intent = Intent(this@Login, MainActivity::class.java)
                    startActivity(intent)
                    dialog?.dismiss()

                } else {
                    Toast.makeText(this@Login, "gagal anjirr", Toast.LENGTH_LONG).show()
                    dialog?.dismiss()
                }
            }
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(this@Login, "error", Toast.LENGTH_LONG).show()
                dialog?.dismiss()
            }

        })

    }
}
