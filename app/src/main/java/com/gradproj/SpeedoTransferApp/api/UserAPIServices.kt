package com.gradproj.SpeedoTransferApp.api

import com.gradproj.SpeedoTransferApp.constants.Constants
import com.gradproj.SpeedoTransferApp.prefrences.SharedPreferencesManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetrofitClient {
    private lateinit var sharedPreferencesManager: SharedPreferencesManager

    // Initialize SharedPreferencesManager
    fun initialize(sharedPreferencesManager: SharedPreferencesManager) {
        this.sharedPreferencesManager = sharedPreferencesManager
    }

    // Build OkHttpClient with AuthInterceptor
    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(sharedPreferencesManager))
            .build()
    }

    // Build Retrofit instance
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: UserApiCallable by lazy {
        retrofit.create(UserApiCallable::class.java)
    }

    fun <T> createService(service: Class<T>): T {
        return retrofit.create(service)
    }
}