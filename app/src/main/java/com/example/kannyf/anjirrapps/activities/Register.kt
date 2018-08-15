package com.example.kannyf.anjirrapps.activities

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.kannyf.anjirrapps.R
import com.example.kannyf.anjirrapps.api.RegisterResponse
import com.example.kannyf.anjirrapps.api.RetrofitClient
import com.tapadoo.alerter.Alerter
import dmax.dialog.SpotsDialog
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class Register : AppCompatActivity(){

    lateinit var editEmail: EditText
    lateinit var editPassword: EditText
    lateinit var editUsername: EditText
    lateinit var regBtn : Button
    lateinit var regLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        editEmail = findViewById(R.id.regEmail)
        editPassword = findViewById(R.id.regPassword)
        editUsername = findViewById(R.id.regUsername)
        regBtn = findViewById(R.id.SignUp)
        regLogin = findViewById(R.id.regLogin)


        regBtn.setOnClickListener { userSignup()}

        regLogin.setOnClickListener { startActivity(Intent(this, Login::class.java)) }
    }

    private fun userSignup() {

        val email = editEmail.text.toString().trim()
        val password = editPassword.text.toString().trim()
        val username = editUsername.text.toString().trim()

        //authentication

        if (email.isEmpty()) {
            editEmail.error = "email is required"
            editEmail.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editEmail.error = "enter valid email"
            editEmail.requestFocus()
            return
        }
        if (password.isEmpty()) {
            editPassword.error = "password is required"
            editPassword.requestFocus()
            return
        }

        if (password.length < 8) {
            editPassword.error = "password lenght must 8 character"
            editPassword.requestFocus()
            return
        }

        if (username.isEmpty()) {
            editUsername.error = "username is required"
            editUsername.requestFocus()
            return
        }

        val dialog: android.app.AlertDialog? = SpotsDialog.Builder().setContext(this).setMessage(R.string.registering).build()
        dialog?.show()

        val call = RetrofitClient
                .instance
                .api
                .createUser(email, password, username)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                dialog?.dismiss()
                val s = null
                try {
                    if(response.code() == 200){
                        val s = response.body()?.string()
                        if (s != null) {
                            Alerter.create(this@Register)
                                    .setText(s)
                                    .show()
                        }
                    }
                    else{
                        val s = response.errorBody()?.string()
                        if (s != null) {
                            Alerter.create(this@Register)
                                    .setText(s)
                                    .show()
                        }
                    }
                }catch (e: IOException){
                    e.printStackTrace()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@Register, t.message, Toast.LENGTH_LONG).show()

            }
        })
    }

}