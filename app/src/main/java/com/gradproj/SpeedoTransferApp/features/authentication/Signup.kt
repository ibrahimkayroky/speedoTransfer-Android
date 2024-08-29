package com.gradproj.SpeedoTransferApp.features.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gradproj.SpeedoTransferApp.R
import com.gradproj.SpeedoTransferApp.ui.components.customButton
import com.gradproj.SpeedoTransferApp.ui.components.customTextField
import com.gradproj.SpeedoTransferApp.ui.theme.P500

@Composable
fun userAuthentication(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {

        Text(
            text = "Sign Up",
            fontWeight = FontWeight(500),
            fontSize = 20.sp,
            modifier = Modifier
                .padding(bottom = 55.dp, top = 8.dp)
        )

        Text(
            text = "Speedo Transfer",
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(bottom = 65.dp)
        )

        customTextField(
            header = "Full Name",
            placeHolder = "Enter Your Full Name",
            icon = ImageVector.vectorResource(id = R.drawable.useric),
            inputType = KeyboardType.Text,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        )

        customTextField(
            header = "Email",
            placeHolder = "Enter Your Email",
            icon = ImageVector.vectorResource(id = R.drawable.emailic),
            inputType = KeyboardType.Text,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        )

        customTextField(
            header = "Password",
            placeHolder = "Enter Your password",
            icon = ImageVector.vectorResource(id = R.drawable.eye_compic_1),
            inputType = KeyboardType.Text,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        )

        customTextField(
            header = "Confirm password",
            placeHolder = "Enter Your password",
            icon = ImageVector.vectorResource(id = R.drawable.eye_compic_1),
            inputType = KeyboardType.Text,
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        
        customButton(
            text = "Sign up",
            onClick = {},
            modifier = Modifier
                .padding(bottom = 16.dp)
                .height(55.dp)
        )
        Row {
            Text(text = "Already have an account? ", color = Color(0xFF898886))
            Text(text = "Sign in", color = Color(0xFF871E35), textDecoration = TextDecoration.Underline)
        }
    }
}