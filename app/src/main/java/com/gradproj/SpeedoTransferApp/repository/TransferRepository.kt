package com.gradproj.SpeedoTransferApp.repository

import com.gradproj.SpeedoTransferApp.api.UserApiCallable
import com.gradproj.SpeedoTransferApp.models.TransferRequest
import com.gradproj.SpeedoTransferApp.models.TransferResponse
import com.gradproj.SpeedoTransferApp.prefrences.SharedPreferencesManager
import retrofit2.Response

class TransferRepository(private val apiService: UserApiCallable, private val sharedPreferencesManager: SharedPreferencesManager){
    fun getToken(): String? {
        return sharedPreferencesManager.getToken()
    }

    suspend fun transfer(amount: Double, receiverAccount: String, receiverName: String): Response<TransferResponse> {
        val response = apiService.transfer(TransferRequest(amount, receiverAccount, receiverName))

        return response
    }
}