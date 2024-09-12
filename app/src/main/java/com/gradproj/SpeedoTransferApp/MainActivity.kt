package com.gradproj.SpeedoTransferApp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.gradproj.SpeedoTransferApp.api.RetrofitClient
import com.gradproj.SpeedoTransferApp.api.UserApiCallable
import com.gradproj.SpeedoTransferApp.navigation.Navigation

import com.gradproj.SpeedoTransferApp.prefrences.PrefrencesHelper.isFirstTimeLaunch
import com.gradproj.SpeedoTransferApp.prefrences.SharedPreferencesManager
import com.gradproj.SpeedoTransferApp.ui.theme.SpeedoTransferAppTheme
import com.gradproj.SpeedoTransferApp.ui.theme.redGradient
import com.gradproj.SpeedoTransferApp.ui.theme.white

class MainActivity : ComponentActivity() {
    private lateinit var sharedPreferencesManager: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        val isFirstTime = isFirstTimeLaunch(this)
        super.onCreate(savedInstanceState)

        // Initialize SharedPreferencesManager
        sharedPreferencesManager = SharedPreferencesManager(this)

        // Initialize RetrofitClient with SharedPreferencesManager
        RetrofitClient.initialize(sharedPreferencesManager)
        installSplashScreen()
        setContent {
            SpeedoTransferAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier
                            .background(Brush.linearGradient(0.0f to white, 1.0f to redGradient))
                    ) {
                        val navController = rememberNavController()


                        Navigation(navController, isFirstTime)
                    }
                }
            }
        }
    }
}
