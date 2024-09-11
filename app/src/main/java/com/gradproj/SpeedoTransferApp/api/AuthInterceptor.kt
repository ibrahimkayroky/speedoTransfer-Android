package com.gradproj.SpeedoTransferApp.api

import com.gradproj.SpeedoTransferApp.constants.Constants
import com.gradproj.SpeedoTransferApp.prefrences.SharedPreferencesManager
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthInterceptor(private val sharedPreferencesManager: SharedPreferencesManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        // Retrieve the token using SharedPreferencesManager instance
        val token = sharedPreferencesManager.getToken()

        // If the token is not empty, add it to the request headers
        val requestBuilder = originalRequest.newBuilder()
        if (!token.isNullOrEmpty()) {
            requestBuilder.addHeader("Authorization", "Bearer $token")
        }

        val newRequest = requestBuilder.build()
        return chain.proceed(newRequest)
    }
}