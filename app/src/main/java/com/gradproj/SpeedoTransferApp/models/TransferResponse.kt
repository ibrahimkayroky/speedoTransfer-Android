package com.gradproj.SpeedoTransferApp.models

data class TransferResponse(
    val amount: Double,
    val id: Int,
    val receiverAccount: String,
    val receiverName: String,
    val status: String
)