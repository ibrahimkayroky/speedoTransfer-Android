package com.gradproj.SpeedoTransferApp.models

data class UpdatePassRequest(
    val newPassword: String,
    val oldPassword: String
)