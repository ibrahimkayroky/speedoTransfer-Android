package com.gradproj.SpeedoTransferApp.prefrences

import android.content.Context

class SharedPreferencesManager(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    // Save token in SharedPreferences
    fun saveToken(token: String) {
        with(sharedPreferences.edit()) {
            putString("auth_token", token)
            apply()
        }
    }

    // Retrieve token from SharedPreferences
    fun getToken(): String? {
        return sharedPreferences.getString("auth_token", null)
    }

    // Clear token (for logout purposes)
    fun clearToken() {
        with(sharedPreferences.edit()) {
            remove("auth_token")
            apply()
        }
    }

}
