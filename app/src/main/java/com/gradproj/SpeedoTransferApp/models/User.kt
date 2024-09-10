package com.gradproj.SpeedoTransferApp.models

data class User(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)