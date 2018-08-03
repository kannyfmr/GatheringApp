package com.example.kannyf.anjirrapps

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("signup") fun createUser(
            @Field("email") email : String,
            @Field("password") password : String,
            @Field("username") username : String
    ) : Call<ResponseBody>
}