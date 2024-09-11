package com.gradproj.SpeedoTransferApp.repository

import com.gradproj.SpeedoTransferApp.api.UserApiCallable
import com.gradproj.SpeedoTransferApp.models.LoginRequest
import com.gradproj.SpeedoTransferApp.models.LoginResponse
import com.gradproj.SpeedoTransferApp.models.UserDataResponse
import com.gradproj.SpeedoTransferApp.prefrences.SharedPreferencesManager
import retrofit2.Response

class UserRepository(private val apiService: UserApiCallable, private val sharedPreferencesManager: SharedPreferencesManager) {

    // Save the token to SharedPreferences after login
    fun saveToken(token: String) {
        sharedPreferencesManager.saveToken(token)
    }

    // Retrieve the token from SharedPreferences
    fun getToken(): String? {
        return sharedPreferencesManager.getToken()
    }

    // Perform the login network request
    suspend fun login(email: String, password: String): Response<LoginResponse> {
        val response = apiService.login(LoginRequest(email, password))

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
    }
