package com.gradproj.SpeedoTransferApp.models

data class TransactionResponseItem(
    val amount: Int,
    val id: Int,
    val receiverAccount: String,
    val receiverName: String,
    val senderAccount: String,
    val status: String
)