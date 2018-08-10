package com.example.kannyf.gajeApp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        private val BASE_URL = "https://api-bambangdwihartono.c9users.io/apimobile/api/web/auth/"
        private var mInstance: RetrofitClient? = null
        val instance: RetrofitClient
            @Synchronized get() {
                if (mInstance == null) {
                    mInstance = RetrofitClient()
                }
                return mInstance!!
            }
    }
    private val retrofit: Retrofit
    val api: Api
        get() = retrofit.create(Api::class.java)

    init {
        retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

}
