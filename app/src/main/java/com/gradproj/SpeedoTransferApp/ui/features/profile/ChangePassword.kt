package com.gradproj.SpeedoTransferApp.ui.features.profile

import android.util.Patterns
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gradproj.SpeedoTransferApp.R

import com.gradproj.SpeedoTransferApp.ui.components.CustomButton
import com.gradproj.SpeedoTransferApp.ui.components.CustomTextField
import com.gradproj.SpeedoTransferApp.ui.features.authentication.isPasswordStrong

@Composable
fun ChangePassword(navController: NavController, modifier: Modifier = Modifier) {
    val userCountry = "Egypt"

    val passwordState = remember { mutableStateOf("") }
    val confirmPasswordState = remember { mutableStateOf("") }

    val isErrorInPassword = remember { mutableStateOf(false) }
    val isErrorInConfirmPassword = remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(16.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.drop_downic),
                contentDescription = "back",
                modifier = Modifier
                    .clickable {
                        navController.popBackStack()
                    }
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Change Password",
                fontWeight = FontWeight.W500,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(end = 32.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        CustomTextField(
            header = "Current Password",
            placeHolder = "Enter Your Password",
            icon = ImageVector.vectorResource(id = R.drawable.useric),
            inputType = KeyboardType.Password,
            textState = passwordState,
            errorState = isErrorInPassword,
            errorMessage = "Enter a stronger password",
            onValueChange = {
                passwordState.value = it
                isErrorInPassword.value = !isPasswordStrong(it)
            },
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        )

        CustomTextField(
            header = "Confirm Password",
            placeHolder = "Enter Your Password",
            icon = ImageVector.vectorResource(id = R.drawable.emailic),
            inputType = KeyboardType.Password,
            textState = confirmPasswordState,
            errorState = isErrorInConfirmPassword,
            errorMessage = "Passwords don't match",
            onValueChange = {
                confirmPasswordState.value = it
                isErrorInConfirmPassword.value = !confirmPasswordState.value.equals(passwordState.value)
            },
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        )

        CustomButton(
            text = "Save",
            onClick = {
                if(isPasswordStrong(passwordState.value) && (passwordState.value.equals(confirmPasswordState.value))) {
                    //handle backend change
                }
            },
            buttonType = "Filled",
            modifier = Modifier
                .padding(bottom = 16.dp)
                .height(55.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ChangePasswordPreview() {
    ChangePassword(navController = rememberNavController())
}