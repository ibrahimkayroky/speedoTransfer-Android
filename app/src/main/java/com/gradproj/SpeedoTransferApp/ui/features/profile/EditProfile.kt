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

@Composable
fun EditProfile(navController: NavController, modifier: Modifier = Modifier) {
    val userCountry = "Egypt"

    val fullNameState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val countryState = remember { mutableStateOf(userCountry) }
    val DOBState = remember { mutableStateOf("") }

    val isErrorInName = remember { mutableStateOf(false) }
    val isErrorInEmail = remember { mutableStateOf(false) }

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
                text = "Edit Profile",
                fontWeight = FontWeight.W500,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(end = 32.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        CustomTextField(
            header = "Full Name",
            placeHolder = "Enter Your Full Name",
            icon = ImageVector.vectorResource(id = R.drawable.useric),
            inputType = KeyboardType.Text,
            textState = fullNameState,
            errorState = isErrorInName,
            errorMessage = "Enter a valid name",
            onValueChange = {
                fullNameState.value = it
                isErrorInName.value = !isInputNotEmpty(it)
            },
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
            errorState = isErrorInEmail,
            errorMessage = "Enter a valid email",
            onValueChange = {
                emailState.value = it
                isErrorInEmail.value = !isEmailValid(it)
            },
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        )

        CustomTextField(
            header = "Country",
            placeHolder = "Select your country",
            icon = ImageVector.vectorResource(id = R.drawable.drop_downic),
            inputType = KeyboardType.Text,
            textState = countryState,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        )
        //
        CustomTextField(
            header = "Date Of Brith",
            placeHolder = "DD/MM/YYY",
            icon = ImageVector.vectorResource(id = R.drawable.dateic),
            inputType = KeyboardType.Text,
            textState = DOBState,
            modifier = Modifier
                .padding(bottom = 24.dp)
                .fillMaxWidth()
        )

        CustomButton(
            text = "Save",
            onClick = {
                if(isInputNotEmpty(fullNameState.value) && isEmailValid(emailState.value)) {
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

fun isInputNotEmpty(input: String): Boolean {
    return input.isNotEmpty()
}

fun isEmailValid(email: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun editProfilePreview() {
    EditProfile(navController = rememberNavController())
}