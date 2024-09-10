package com.gradproj.SpeedoTransferApp.prefrences

import android.content.Context
import android.content.SharedPreferences

object PrefrencesHelper {

    private const val PREFERENCES_FILE_NAME = "app_prefs"
    private const val IS_FIRST_TIME = "is_first_time"

    fun isFirstTimeLaunch(context: Context): Boolean {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
            PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(IS_FIRST_TIME, true)
    }

    fun setFirstTimeLaunch(context: Context, isFirstTime: Boolean) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
            PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putBoolean(IS_FIRST_TIME, isFirstTime)
            apply()
        }
    }
}