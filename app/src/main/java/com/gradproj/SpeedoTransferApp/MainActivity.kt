package com.gradproj.SpeedoTransferApp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gradproj.SpeedoTransferApp.features.mainApp.HomeScreen
import com.gradproj.SpeedoTransferApp.features.mainApp.TransferAmount
import com.gradproj.SpeedoTransferApp.features.mainApp.TransferConfirmation
import com.gradproj.SpeedoTransferApp.features.mainApp.TransferPayment

import com.gradproj.SpeedoTransferApp.features.navigation.Navigation
import com.gradproj.SpeedoTransferApp.ui.theme.SpeedoTransferAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpeedoTransferAppTheme {
                Surface() {
                    Navigation(modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}
