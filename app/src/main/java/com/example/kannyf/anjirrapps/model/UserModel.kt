package com.example.kannyf.anjirrapps.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class UserModel {

    @SerializedName("avatar_url")
    @Expose
    open var avatarUrl : String? = null

    @SerializedName("name")
    @Expose
    open var name : String? = null

    @SerializedName("company")
    @Expose
    open var company : String? = null
}