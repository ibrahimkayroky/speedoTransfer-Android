package com.gradproj.SpeedoTransferApp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gradproj.SpeedoTransferApp.api.UserApiServices
import com.gradproj.SpeedoTransferApp.models.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel(){
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products = _products.asStateFlow()
    private val _hasError = MutableStateFlow(false)
    val hasError = _hasError.asStateFlow()
    init {
        getUsers()
    }
    fun getUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _products.update {
                    UserApiServices.callable.getUsers().products
                }
                _hasError.update { false }
            } catch (e: Exception) {
                Log.d("trace", "Error : ${e.message}")
                _hasError.update { true }
            }
        }
    }
}