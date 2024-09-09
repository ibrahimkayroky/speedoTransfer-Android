package com.gradproj.SpeedoTransferApp


import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gradproj.SpeedoTransferApp.features.navigation.Navigation
import com.gradproj.SpeedoTransferApp.features.navigation.Screen
import com.gradproj.SpeedoTransferApp.features.prefrences.PrefrencesHelper.isFirstTimeLaunch
import com.gradproj.SpeedoTransferApp.ui.theme.SpeedoTransferAppTheme
import com.gradproj.SpeedoTransferApp.ui.theme.redGradient
import com.gradproj.SpeedoTransferApp.ui.theme.white

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val isFirstTime = isFirstTimeLaunch(this)

        super.onCreate(savedInstanceState)
        setContent {
            SpeedoTransferAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize() // Ensure Surface fills the entire screen
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
