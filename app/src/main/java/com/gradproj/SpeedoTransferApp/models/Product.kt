package com.gradproj.SpeedoTransferApp.models

import com.google.gson.annotations.SerializedName

class Products(val products: List<Product>)
data class Product(
    @SerializedName("brand")
    val br: String,
    val category: String,
    val description: String,

    val id: Int,

    val price: Double,

)