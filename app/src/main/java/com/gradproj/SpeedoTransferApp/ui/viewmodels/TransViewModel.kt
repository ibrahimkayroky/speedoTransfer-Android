package com.gradproj.SpeedoTransferApp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.gradproj.SpeedoTransferApp.models.TransactionResponse
import com.gradproj.SpeedoTransferApp.models.UserDataResponse
import com.gradproj.SpeedoTransferApp.repository.TransactionRepository
import com.gradproj.SpeedoTransferApp.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TransViewModel(private val repository: TransactionRepository) : ViewModel() {
    private val _transcations = MutableStateFlow<TransactionResponse?>(null)
    val transactions: StateFlow<TransactionResponse?> get() = _transcations
    init {
        getTransactions()
    }

    fun getTransactions(){
        viewModelScope.launch {
            try {
                val response = repository.getTransactions()
                if (response.isSuccessful) {
                    // Update StateFlow with transactions data
                    _transcations.value = response.body()
                } else {
                    // Handle error (you can update another state or show a message)
                    _transcations.value = null
                }
            } catch (e: Exception) {
                // Handle network errors
                _transcations.value = null
            }
        }
    }
}

class TransViewModelFactory(
    private val repository: TransactionRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TransViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TransViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}