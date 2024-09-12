package com.gradproj.SpeedoTransferApp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.gradproj.SpeedoTransferApp.models.UserDataResponse
import com.gradproj.SpeedoTransferApp.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
class UserViewModel(private val repository: UserRepository) : ViewModel() {

    // StateFlow to hold the user data
    private val _userData = MutableStateFlow<UserDataResponse?>(null)
    val userData: StateFlow<UserDataResponse?> get() = _userData
    init {
        getUserData()
    }

    // Method to fetch user data from repository
    fun getUserData() {
        viewModelScope.launch {
            try {
                val response = repository.getUserData()
                if (response.isSuccessful) {
                    // Update StateFlow with user data
                    _userData.value = response.body()
                    Log.d("trace","${_userData.value?.name} response succeful")
                } else {
                    // Handle error (you can update another state or show a message)
                    Log.d("trace","${_userData.value} response not succeful")
                    _userData.value = null
                }
            } catch (e: Exception) {
                // Handle network errors
                _userData.value = null
            }
        }
    }
    fun updateUserPass(oldPass:String,newPass:String){
        viewModelScope.launch {
            try{
            val response = repository.updatePass(oldPass,newPass)

                Log.d("trace","response not succeful")
            } catch (e: Exception) {
                // Handle network errors
                Log.d("trace","error: ${e.message}")
            }
        }
    }
    fun updateProfile(country:String,email:String,name:String){
        viewModelScope.launch {
            try{
                val response = repository.updateProfile(country,email,name)

                Log.d("trace","response not succeful")
            } catch (e: Exception) {
                // Handle network errors
                Log.d("trace","error: ${e.message}")
            }
        }
    }

}

class UserViewModelFactory(
    private val repository: UserRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

