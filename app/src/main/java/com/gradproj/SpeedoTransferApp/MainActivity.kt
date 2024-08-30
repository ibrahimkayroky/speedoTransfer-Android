package com.gradproj.SpeedoTransferApp


import SignIn
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.padding

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gradproj.SpeedoTransferApp.features.authentication.SignupContinue
import com.gradproj.SpeedoTransferApp.features.authentication.UserAuthentication
import com.gradproj.SpeedoTransferApp.ui.components.GradientBackground
import com.gradproj.SpeedoTransferApp.ui.theme.SpeedoTransferAppTheme
import com.gradproj.SpeedoTransferApp.ui.theme.white

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpeedoTransferAppTheme {


                SignIn(modifier = Modifier.padding(16.dp))


            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun UserAuthenticationPreview()
{
    UserAuthentication()
}