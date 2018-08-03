package com.example.kannyf.anjirrapps

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Register : AppCompatActivity(){

    lateinit var editEmail: EditText
    lateinit var editPassword: EditText
    lateinit var editUsername: EditText
    lateinit var regBtn : Button
    lateinit var mProgressdialog : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        editEmail = findViewById(R.id.regEmail)
        editPassword = findViewById(R.id.regPass)
        editUsername = findViewById(R.id.regUsername)
        regBtn = findViewById(R.id.SignUp)

        regBtn.setOnClickListener { userSignup() }

    }

    private fun userSignup() {

        mProgressdialog.showContextMenu()

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

        val call = RetrofitClient
                .instance
                .api
                .createUser(email, password, username)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Toast.makeText(this@Register, "successfully register", Toast.LENGTH_LONG).show()

            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@Register, t.message, Toast.LENGTH_LONG).show()

            }
        })
    }

}