package com.gradproj.SpeedoTransferApp.models

data class TransferRequest(
    val amount: Double,
    val receiverAccount: String,
    val receiverName: String
)