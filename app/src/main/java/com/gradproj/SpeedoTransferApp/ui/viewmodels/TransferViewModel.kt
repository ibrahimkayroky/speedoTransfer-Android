package com.gradproj.SpeedoTransferApp.ui.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.gradproj.SpeedoTransferApp.models.TransferResponse
import com.gradproj.SpeedoTransferApp.repository.TransferRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TransferViewModel(private val Repository: TransferRepository): ViewModel() {

    private val _transferData = MutableStateFlow<TransferResponse?>(null)
    val transferData: StateFlow<TransferResponse?> get() = _transferData

    fun transfer(receiverName: String, receiverAccount: String, amount: Double){

        viewModelScope.launch {
            try {
                val response = Repository.transfer(amount, receiverAccount, receiverName)

                if(response.isSuccessful){
                    _transferData.value = response.body()
                } else {
                    _transferData.value = null
                }
            } catch (e: Exception) {
                Log.d("exception", e.toString())
                _transferData.value = null
            }
        }
    }
}

class TransferViewModelFactory(
    private val repository: TransferRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TransferViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TransferViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}