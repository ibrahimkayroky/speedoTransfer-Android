package com.gradproj.SpeedoTransferApp.models

data class UserDataResponse(
    val balance: Int,
    val birthDate: String,
    val createdAt: String,
    val email: String,
    val id: Int,
    val name: String,
    val updatedAt: String
)