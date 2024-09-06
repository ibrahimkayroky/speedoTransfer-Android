package com.gradproj.SpeedoTransferApp.features.authentication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.navigation.NavController
import com.gradproj.SpeedoTransferApp.R
import com.gradproj.SpeedoTransferApp.features.navigation.Screen
import com.gradproj.SpeedoTransferApp.ui.components.CustomButton
import com.gradproj.SpeedoTransferApp.ui.components.CustomTextField

@Composable
fun SignUp(navController: NavController, modifier: Modifier = Modifier) {

    val nameState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val confirmPasswordState = remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
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
            fontWeight = FontWeight(600),
            fontSize = 24.sp,
            modifier = Modifier
                .padding(bottom = 65.dp)
        )

        CustomTextField(
            header = "Full Name",
            placeHolder = "Enter Your Full Name",
            icon = ImageVector.vectorResource(id = R.drawable.useric),
            inputType = KeyboardType.Text,
            textState = nameState,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        )

        CustomTextField(
            header = "Email",
            placeHolder = "Enter Your Email",
            icon = ImageVector.vectorResource(id = R.drawable.emailic),
            inputType = KeyboardType.Text,
            textState = emailState,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        )

        CustomTextField(
            header = "Password",
            placeHolder = "Enter Your password",
            icon = ImageVector.vectorResource(id = R.drawable.eye_compic_1),
            inputType = KeyboardType.Password,
            textState = passwordState,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        )

        CustomTextField(
            header = "Confirm password",
            placeHolder = "Enter Your password",
            icon = ImageVector.vectorResource(id = R.drawable.eye_compic_1),
            inputType = KeyboardType.Password,
            textState = confirmPasswordState,
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )

        CustomButton(
            text = "Sign up",
            onClick = { navController.navigate(Screen.SignUpContinue.route + "/${nameState}" + "/${emailState}" + "/${passwordState}") },
            buttonType = "Filled",
            modifier = Modifier
                .padding(bottom = 16.dp)
                .height(55.dp)
        )

        Row {
            Text(text = "Already have an account? ", color = Color(0xFF898886))
            Text(
                text = "Sign in",
                color = Color(0xFF871E35),
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screen.Signin.route)
                    }
            )
        }
    }
}
