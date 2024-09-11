package com.gradproj.SpeedoTransferApp.repository

import com.gradproj.SpeedoTransferApp.api.UserApiCallable
import com.gradproj.SpeedoTransferApp.models.FavoriteResponse
import com.gradproj.SpeedoTransferApp.prefrences.SharedPreferencesManager
import retrofit2.Response


class FavoriteRepository(private val apiService: UserApiCallable, private val sharedPreferencesManager: SharedPreferencesManager) {
    // Retrieve the token from SharedPreferences
    fun getToken(): String? {
        return sharedPreferencesManager.getToken()
    }

    suspend fun getFavorites(): Response<FavoriteResponse> {
        val token = getToken()

        return if (token != null) {
            // Pass the token as a Bearer token in the header
            apiService.getFavorites("Bearer $token")
        } else {
            throw IllegalStateException("Token not found. User must log in first.")
        }
    }
}