package com.gradproj.SpeedoTransferApp.features.authentication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.gradproj.SpeedoTransferApp.R
import com.gradproj.SpeedoTransferApp.ui.components.customTextField

@Composable
fun userAuthentication(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()) {

        Text(text = "Sign Up")
        Text(text = "Speedo Transfer")

        customTextField(
            header = "Full Name",
            placeHolder = "Enter Your Full Name",
            icon = ImageVector.vectorResource(id = R.drawable.useric)
        )
    }
}