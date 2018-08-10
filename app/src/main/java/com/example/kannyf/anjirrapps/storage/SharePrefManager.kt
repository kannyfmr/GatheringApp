package com.example.kannyf.anjirrapps.storage

import android.content.Context
import com.example.kannyf.anjirrapps.model.User


class SharePrefManager {
    private val SHARED_PREF_NAME = "my_sharedpref_name"
    private var mInstance: SharePrefManager? = null
    private lateinit var mCtx: Context

    private fun sharePrefManager(mCtx: Context): SharePrefManager? {
        this.mCtx = mCtx
        return null
    }
    @Synchronized
    fun getmInstance(mCtx: Context): SharePrefManager {
        if (mInstance == null) {
            mInstance = sharePrefManager(mCtx)
        }
        return mInstance as SharePrefManager

    }

    fun savedUser(user: User) {
        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putInt("id", user.getId())
        editor.putString("email", user.getEmail())
        editor.putString("name", user.getName())
        editor.putString("school", user.getSchool())

        editor.apply()

    }

    fun isLoggedin(): Boolean {
        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getInt("id", -1) != -1

    }

    fun getUser(): User {
        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        return User(
                sharedPreferences.getInt("id", -1),
                sharedPreferences.getString("email", null),
                sharedPreferences.getString("name", null),
                sharedPreferences.getString("school", null)
        )

    }

    fun clear() {
        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply()
        editor.clear()

    }

}