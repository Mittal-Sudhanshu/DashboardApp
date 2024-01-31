package com.example.openinapp.data.sharePref

import android.content.Context

class SharedPreference(private val context: Context) {
    private val sharedPref = context.getSharedPreferences("Login", Context.MODE_PRIVATE)
    fun saveToken(token: String) {
        sharedPref.edit().putString("token", token).apply()
    }

    fun getToken(): String? {
        return sharedPref.getString("token", null)
    }
    fun removeToken(){
        sharedPref.edit().remove("token").apply()
    }
}