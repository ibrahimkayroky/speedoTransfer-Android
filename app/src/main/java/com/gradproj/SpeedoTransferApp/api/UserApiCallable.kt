package com.gradproj.SpeedoTransferApp.api

import com.gradproj.SpeedoTransferApp.constants.Constants
import com.gradproj.SpeedoTransferApp.models.FavoriteResponse
import com.gradproj.SpeedoTransferApp.models.LoginRequest
import com.gradproj.SpeedoTransferApp.models.LoginResponse
import com.gradproj.SpeedoTransferApp.models.TransactionResponse
import com.gradproj.SpeedoTransferApp.models.TransferRequest
import com.gradproj.SpeedoTransferApp.models.TransferResponse
import com.gradproj.SpeedoTransferApp.models.UserDataResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface UserApiCallable {

        // Example login API that returns a token

    @POST(Constants.AUTH_URL)
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>
    @GET(Constants.GET_USER)
    suspend fun getUserData(  @Header("Authorization") token: String): Response<UserDataResponse>

    @GET(Constants.GET_TRANSACTIONS)
    suspend fun getTransactions(  @Header("Authorization") token: String): Response<TransactionResponse>

    @POST(Constants.TRANSFER_URL)
    suspend fun transfer(
        @Body TransferRequest: TransferRequest
    ): Response<TransferResponse>

    @GET(Constants.GET_FAVORITES)
    suspend fun getFavorites(  @Header("Authorization") token: String): Response<FavoriteResponse>


}