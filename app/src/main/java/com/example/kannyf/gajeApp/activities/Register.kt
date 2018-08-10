package com.example.kannyf.gajeApp.activities

import android.app.AlertDialog
import android.app.ProgressDialog
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kannyf.gajeApp.R
import com.example.kannyf.gajeApp.api.RetrofitClient
import com.tapadoo.alerter.Alerter
import dmax.dialog.SpotsDialog
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class Register : AppCompatActivity(){

    lateinit var editEmail: EditText
    lateinit var editPassword: EditText
    lateinit var editPassword2: EditText
    lateinit var editUsername: EditText
    lateinit var regBtn : Button
    lateinit var mProgressDialog: ProgressDialog
    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        editEmail = findViewById(R.id.regEmail)
        editPassword = findViewById(R.id.regPass)
        editPassword2 = findViewById(R.id.regPass2)
        editUsername = findViewById(R.id.regUsername)
        regBtn = findViewById(R.id.SignUp)
        mProgressDialog = ProgressDialog(this)

        regBtn.setOnClickListener {
            userSignup()
        }

    }

    private fun userSignup() {

        val email = editEmail.text.toString().trim()
        val password = editPassword.text.toString().trim()
        val password2 = editPassword2.text.toString().trim()
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

        if (password != password2){
            editPassword.error = "Password not match!"
            editPassword2.error = "Password not match!"
            editPassword2.requestFocus()
            return
        }

        if (username.isEmpty()) {
            editUsername.error = "username is required"
            editUsername.requestFocus()
            return
        }

        dialog = SpotsDialog.Builder()
                .setContext(this@Register)
                .setMessage("Processing...")
                .setCancelable(false)
                .build()
                .apply {
                    show()
                }

        val call = RetrofitClient
                .instance
                .api
                .createUser(email, password, username)

        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                dialog.dismiss()
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

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                dialog.dismiss()
                Toast.makeText(applicationContext, t?.message, Toast.LENGTH_SHORT).show()
//                Alerter.create(this@Register)
//                        .setText(t?.message.toString())
//                        .show()
            }
        })
    }

}