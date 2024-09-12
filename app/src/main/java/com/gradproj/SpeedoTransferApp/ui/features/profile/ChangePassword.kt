package com.gradproj.SpeedoTransferApp.ui.features.profile

import android.util.Patterns
import android.widget.Toast
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
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
import com.gradproj.SpeedoTransferApp.navigation.Screen

import com.gradproj.SpeedoTransferApp.ui.components.CustomButton
import com.gradproj.SpeedoTransferApp.ui.components.CustomTextField
import com.gradproj.SpeedoTransferApp.ui.features.authentication.isPasswordStrong
import com.gradproj.SpeedoTransferApp.ui.viewmodels.AuthViewModel
import com.gradproj.SpeedoTransferApp.ui.viewmodels.UserViewModel

@Composable
fun ChangePassword(navController: NavController, userviewModel: UserViewModel, authViewModel: AuthViewModel, modifier: Modifier = Modifier) {

    val context = LocalContext.current



    val oldPasswordState = remember { mutableStateOf("") }
    val confirmPasswordState = remember { mutableStateOf("") }

    // val isErrorInPassword = remember { mutableStateOf(false) }
    //val isErrorInConfirmPassword = remember { mutableStateOf(false) }

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
            textState = oldPasswordState,

            errorMessage = "Enter a stronger password",
            onValueChange = {
                oldPasswordState.value = it

            },
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        )

        CustomTextField(
            header = "New Password",
            placeHolder = "Enter your password",
            icon = ImageVector.vectorResource(id = R.drawable.emailic),
            inputType = KeyboardType.Password,
            textState = confirmPasswordState,

            onValueChange = {
                confirmPasswordState.value = it

            },
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        )

        CustomButton(
            text = "Save",
            onClick = {
                if(!isPasswordStrong(confirmPasswordState.value) ) {
                    //text appears that password is not strong

                }
                else
                {
                    userviewModel.updateUserPass(oldPasswordState.value,confirmPasswordState.value)
                    Toast.makeText(context, "Password changed successfully", Toast.LENGTH_SHORT).show()
                    authViewModel.logout()
                    navController.navigate(Screen.Signin.route)
                }
            },
            buttonType = "Filled",
            modifier = Modifier
                .padding(bottom = 16.dp)
                .height(55.dp)
        )
    }
}
/*

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ChangePasswordPreview() {
    ChangePassword(navController = rememberNavController())
}*/
