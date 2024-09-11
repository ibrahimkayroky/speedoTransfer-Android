package com.gradproj.SpeedoTransferApp.ui.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewModelScope
import com.gradproj.SpeedoTransferApp.api.RetrofitClient
import com.gradproj.SpeedoTransferApp.prefrences.SharedPreferencesManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.compose.ui.platform.LocalContext
import com.gradproj.SpeedoTransferApp.repository.UserRepository

class AuthViewModel(private val context: Context,private val userRepository: UserRepository): ViewModel() {
    private val sharedPreferencesManager: SharedPreferencesManager by lazy {
        SharedPreferencesManager(context)
    }

    private val _loginState = MutableStateFlow<Boolean?>(null)
    val loginState: StateFlow<Boolean?> get() = _loginState

    // Method to handle user login
    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                // Call your API to perform login (replace this with actual login API)
                val response = userRepository.login(email, password)

                if (response.isSuccessful && response.body() != null) {
                    // Assume token comes in response body
                    val token = response.body()?.token
                     Log.d("trace", "Token: $token")

                    // Save token in SharedPreferences
                    if (token != null) {
                        sharedPreferencesManager.saveToken(token)
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

    // Method to handle user logout
    fun logout() {
        // Clear token from SharedPreferences
        sharedPreferencesManager.clearToken()
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