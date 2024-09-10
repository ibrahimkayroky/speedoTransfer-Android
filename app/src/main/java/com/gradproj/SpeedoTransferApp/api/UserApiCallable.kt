package com.gradproj.SpeedoTransferApp.api

import com.gradproj.SpeedoTransferApp.models.Product
import com.gradproj.SpeedoTransferApp.models.Products
import retrofit2.http.GET

interface UserApiCallable {
    @GET("products")

    suspend fun getUsers(): Products

}