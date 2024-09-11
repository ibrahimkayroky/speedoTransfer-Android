package com.gradproj.SpeedoTransferApp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.gradproj.SpeedoTransferApp.models.FavoriteResponse
import com.gradproj.SpeedoTransferApp.repository.FavoriteRepository
import com.gradproj.SpeedoTransferApp.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoriteViewModel(private val repository: FavoriteRepository) : ViewModel() {
    // StateFlow to hold the user data
    private val _favorites = MutableStateFlow<FavoriteResponse?>(null)
    val favorites: StateFlow<FavoriteResponse?> get() = _favorites
    init {
        getFavorites()
    }

    // Method to fetch user data from repository
    fun getFavorites() {
        viewModelScope.launch {
            try {
                val response = repository.getFavorites()
                if (response.isSuccessful) {
                    // Update StateFlow with user data
                    _favorites.value = response.body()
                } else {
                    // Handle error (you can update another state or show a message)
                    _favorites.value = null
                }
            } catch (e: Exception) {
                // Handle network errors
                _favorites.value = null
            }
        }
    }
}

class FavoriteViewModelFactory(
    private val repository: FavoriteRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoriteViewModelFactory::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavoriteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}