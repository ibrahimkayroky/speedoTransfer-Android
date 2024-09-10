package com.gradproj.SpeedoTransferApp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserApiServices {
    private val retrofit = Retrofit
        .Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val callable by lazy {
        retrofit.create(UserApiCallable::class.java)
    }
}