package com.gradproj.SpeedoTransferApp.models

data class Account(
    val accountName: String,
    val accountNumber: String,
    val accountType: String,
    val active: Boolean,
    val balance: Int,
    val createdAt: String,
    val currency: String,
    val id: Int,
    val updatedAt: String,
    val user: String
)