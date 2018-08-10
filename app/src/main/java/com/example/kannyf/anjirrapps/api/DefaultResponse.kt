package com.example.kannyf.gajeApp.api

import com.google.gson.annotations.SerializedName

class DefaultResponse{
    @SerializedName("error")
    var err: Boolean? = null

    @SerializedName("message")
    var msg: String? = null

}