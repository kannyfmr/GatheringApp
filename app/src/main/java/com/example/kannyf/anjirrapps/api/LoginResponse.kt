package com.example.kannyf.anjirrapps.api

import com.example.kannyf.anjirrapps.model.User

class LoginResponse {
    private var error: Boolean = true
    private var message: String = ""
    private var user: User? = null

    fun LoginResponse(error: Boolean, message: String, user: User) {
        this.error = error
        this.message = message
        this.user = user
    }

    fun isError(): Boolean {
        return error
    }

    fun getMessage(): String {
        return message
    }

    fun getUser(): User {
        return user!!
    }
}