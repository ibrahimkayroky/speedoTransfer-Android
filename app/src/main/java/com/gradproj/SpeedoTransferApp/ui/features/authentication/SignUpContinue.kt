package com.gradproj.SpeedoTransferApp.ui.features.authentication



import android.app.DatePickerDialog
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gradproj.SpeedoTransferApp.R
import com.gradproj.SpeedoTransferApp.navigation.Screen
import com.gradproj.SpeedoTransferApp.ui.components.CustomButton
import com.gradproj.SpeedoTransferApp.ui.components.ExtraType
import com.gradproj.SpeedoTransferApp.ui.components.GradientBackground
import com.gradproj.SpeedoTransferApp.ui.theme.G100
import com.gradproj.SpeedoTransferApp.ui.theme.G900
import com.gradproj.SpeedoTransferApp.ui.theme.P300
import com.gradproj.SpeedoTransferApp.ui.viewmodels.AuthViewModel
import com.gradproj.SpeedoTransferApp.ui.viewmodels.RegistrationState
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import com.gradproj.SpeedoTransferApp.ui.components.CustomTextField as CustomTextField1


@Composable
fun SignupContinue(navController: NavController, name: String?, email: String?, password: String?, viewModel: AuthViewModel,
                   modifier: Modifier = Modifier) {

    val countryState = remember { mutableStateOf("") }
    val dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.getDefault())
    val dateState = remember { mutableStateOf(LocalDate.now().format(dateFormatter)) }


    // Convert String to LocalDate when needed
    fun parseDate(dateString: String): LocalDate? {
        return try {
            LocalDate.parse(dateString, dateFormatter)
        } catch (e: Exception) {
            null
        }
    }
    //val loginState by viewModel.loginState.collectAsState()
    val registerState by viewModel.registerState.collectAsState()
    // Handle registration state
    when (registerState) {
        is RegistrationState.Loading -> {
            // Show loading indicator if needed
            Text(text = "Loading...")
        }
        is RegistrationState.Success -> {
            // Navigate to the home screen upon success
            LaunchedEffect(Unit) {
                navController.navigate(Screen.Home.route)
            }
        }
        is RegistrationState.Error -> {
            // Show error message
            Text(text = (registerState as RegistrationState.Error).message)
        }
        null -> { /* Initial state, do nothing */ }
    }
    GradientBackground {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxWidth()
        ) {
            Icon(painter = painterResource(id = R.drawable.drop_downic), contentDescription = "back",modifier = Modifier.align(Alignment.Start))
            Column( horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.fillMaxWidth()) {
                Text(
                    text = "Welcome to Banque Misr!",
                    fontWeight = FontWeight(600),
                    color = G900,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(bottom = 8.dp, top = 8.dp)

                )
                Text(
                    text = "Let’s Complete your Profile",
                    fontWeight = FontWeight(400),
                    color = G900,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(bottom = 8.dp, top = 8.dp)
                )
            }

            CustomTextField1(
                header = "Country",
                placeHolder = "Select your country",
                icon = ImageVector.vectorResource(id = R.drawable.drop_downic),
                inputType = KeyboardType.Text,
                textState = countryState,
                extratype = ExtraType.country,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )

            CustomTextField1(
                header = "Date Of Birth",
                placeHolder = "dd-MM-YYYY",
                icon = ImageVector.vectorResource(id = R.drawable.dateic),
                inputType = KeyboardType.Text,
                textState = dateState,
                extratype = ExtraType.date,
                onValueChange = { newText ->
                    // Validate the new date string before updating dateState
                    val parsedNewDate = parseDate(newText)
                    if (parsedNewDate != null) {
                        dateState.value = newText // Update only if the date is valid
                    } else {
                        Log.e("Signup", "Invalid date format input: $newText")
                    }
                },
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
            )


            val parsedDate = parseDate(dateState.value)
            CustomButton(
                text = "Continue",
                onClick = {
                    Log.d("Signup", "Continue button clicked with data - Country: ${countryState.value}, Date: $parsedDate")
                    if (email != null && name != null && password != null) {
                      //  if (parsedDate != null) {
                            Log.d("Signup", "Continue button clicked with data - Country: ${countryState.value}, Date: $parsedDate")
                            viewModel.register(

                                email = email,
                                name = name,
                                country = countryState.value,
                                password = password
                            )

                       // }
                    } else {
                        Log.e("Signup", "Missing required fields")
                    }},
                buttonType = "Filled",
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .height(55.dp)
            )

            Row {
                Text(
                    text = "Already have an account? ",
                    color = G100
                )
                Text(text = "Sign in",
                    color = P300,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                        .clickable {
                            navController.navigate(Screen.Signin.route)
                        }
                )
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun  SignupContinuePreview() {
    //SignupContinue()
}