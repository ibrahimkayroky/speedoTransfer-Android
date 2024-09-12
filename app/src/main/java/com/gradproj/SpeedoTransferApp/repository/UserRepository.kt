package com.gradproj.SpeedoTransferApp.repository

import android.util.Log
import com.gradproj.SpeedoTransferApp.api.UserApiCallable
import com.gradproj.SpeedoTransferApp.models.LoginRequest
import com.gradproj.SpeedoTransferApp.models.LoginResponse
import com.gradproj.SpeedoTransferApp.models.RegisterRequest
import com.gradproj.SpeedoTransferApp.models.RegisterResponce
import com.gradproj.SpeedoTransferApp.models.UpdatePassRequest
import com.gradproj.SpeedoTransferApp.models.UpdateProfileRequest
import com.gradproj.SpeedoTransferApp.models.UserDataResponse
import com.gradproj.SpeedoTransferApp.prefrences.SharedPreferencesManager
import retrofit2.Response
import java.time.LocalDate
import java.util.Date

class UserRepository(
    private val apiService: UserApiCallable,
    private val sharedPreferencesManager: SharedPreferencesManager
) {

    // Save the token to SharedPreferences after login
    fun saveToken(token: String) {
        sharedPreferencesManager.saveToken(token)
    }

    // Retrieve the token from SharedPreferences
    fun getToken(): String? {
        return sharedPreferencesManager.getToken()
    }

    fun clearToken() {
        return sharedPreferencesManager.clearToken()
    }

    // Perform the login network request
    suspend fun login(email: String, password: String): Response<LoginResponse> {
        val response = apiService.login(LoginRequest(email, password))
        Log.d("trace", "Token: ${response}")
        if (response.isSuccessful) {
            // Assuming the token is in the response body
            val token = response.body()?.token

            // Save token if it's not null
            token?.let {
                saveToken(it)
            }
        }

        return response
    }

    suspend fun register(

        email: String,
        name: String,
        country: String,
        password: String,
    ): Response<RegisterResponce> {
        val response = apiService.register(RegisterRequest(country, email, name, password))

        if (response.isSuccessful) {
            // Assuming the token is in the response body
            val token = response.body()?.token
            Log.d("trace", "Token: $token register was succesful")

            // Save token if it's not null
            token?.let {
                saveToken(it)
            }
        }

        return response
    }

    // Example of an API request that requires the token
    suspend fun getUserData(): Response<UserDataResponse> {
        val token = getToken()

        return if (token != null) {
            // Pass the token as a Bearer token in the header
            apiService.getUserData("Bearer $token")
        } else {
            throw IllegalStateException("Token not found. User must log in first.")
        }
    }
    suspend fun updatePass( oldPassword: String, newPassword: String,){
        val token = getToken()
        if (token != null) {
           apiService.updatePassword("Bearer $token",UpdatePassRequest(newPassword, oldPassword))
        } else {
            throw IllegalStateException("Token not found. User must log in first.")
        }
    }
    suspend fun updateProfile(  country: String,
                                 email: String,
                                 name: String){
        val token = getToken()
        if (token != null) {
            apiService.updateProfile("Bearer $token",UpdateProfileRequest(country, email, name))
        } else {
            throw IllegalStateException("Token not found. User must log in first.")
        }
    }
}
