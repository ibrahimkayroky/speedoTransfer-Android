package com.gradproj.SpeedoTransferApp.ui.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewModelScope
import com.gradproj.SpeedoTransferApp.prefrences.SharedPreferencesManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModelProvider
import com.gradproj.SpeedoTransferApp.repository.UserRepository
import java.time.LocalDate

sealed class RegistrationState {
    object Loading : RegistrationState()
    object Success : RegistrationState()
    data class Error(val message: String) : RegistrationState()
}
class AuthViewModel(private val context: Context,private val userRepository: UserRepository): ViewModel() {
    private val sharedPreferencesManager: SharedPreferencesManager by lazy {
        SharedPreferencesManager(context)
    }

    private val _loginState = MutableStateFlow<Boolean?>(null)
    val loginState: StateFlow<Boolean?> get() = _loginState
    private val _registerState = MutableStateFlow<RegistrationState?>(null)
    val registerState: StateFlow<RegistrationState?> = _registerState

    // Method to handle user login
    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                userRepository.clearToken()
                // Call your API to perform login (replace this with actual login API)
                val response = userRepository.login(email, password)
                Log.d("trace", "Token: ${response}")
                if (response.isSuccessful && response.body() != null) {
                    // Assume token comes in response body
                    val token = response.body()?.token
                     Log.d("trace", "Token: $token")

                    // Save token in SharedPreferences
                    if (token != null) {
                        userRepository.saveToken(token)
                    }

                    // Update login state
                    _loginState.value = true
                } else {
                    _loginState.value = false
                }
            } catch (e: Exception) {
                _loginState.value = false
            }
        }
    }

fun register(

             email: String,
             name: String,
             country: String,
             password: String,){
    viewModelScope.launch {
        _registerState.value = RegistrationState.Loading
        try {
            userRepository.clearToken()
            // Call your API to perform login (replace this with actual login API)
            val response = userRepository.register(email,name,country, password)
            Log.d("trace", "Token: ${response}")
            if (response.isSuccessful && response.body() != null) {
                // Assume token comes in response body
                val token = response.body()?.token
                Log.d("trace", "Token: $token")

                // Save token in SharedPreferences
                if (token != null) {
                    userRepository.saveToken(token)
                }

                // Update login state
                _registerState.value = RegistrationState.Success
            } else {
                _registerState.value = RegistrationState.Error("Registration failed: ${response.message()}")
            }
        } catch (e: Exception) {
            _registerState.value = RegistrationState.Error("An error occurred: ${e.localizedMessage}")
        }
    }

}
    // Method to handle user logout
    fun logout() {
        // Clear token from SharedPreferences

        _loginState.value=false
        Log.d("trace", "logout done ${loginState}")
        userRepository.clearToken()
    }
}
class AuthViewModelFactory(
    private val userRepository: UserRepository
    ,private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AuthViewModel(context,userRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}