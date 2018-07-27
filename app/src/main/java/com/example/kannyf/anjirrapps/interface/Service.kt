package com.example.kannyf.anjirrapps.`interface`

import com.example.kannyf.anjirrapps.model.UserModel
import retrofit.http.GET
import retrofit.http.Path
import rx.Observable

interface Service {

    @GET("users/{username}")

    fun getUser(@Path("username") username : String) : Observable<UserModel>
}