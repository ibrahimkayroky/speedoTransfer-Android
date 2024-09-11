import android.util.Log
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

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gradproj.SpeedoTransferApp.R
import com.gradproj.SpeedoTransferApp.navigation.Screen

import com.gradproj.SpeedoTransferApp.ui.components.CustomButton
import com.gradproj.SpeedoTransferApp.ui.components.CustomTextField
import com.gradproj.SpeedoTransferApp.ui.components.GradientBackground
import com.gradproj.SpeedoTransferApp.ui.theme.G100
import com.gradproj.SpeedoTransferApp.ui.theme.P300
import com.gradproj.SpeedoTransferApp.ui.viewmodels.AuthViewModel
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.observe
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.gradproj.SpeedoTransferApp.api.RetrofitClient
import com.gradproj.SpeedoTransferApp.prefrences.SharedPreferencesManager
import com.gradproj.SpeedoTransferApp.repository.UserRepository
import com.gradproj.SpeedoTransferApp.ui.viewmodels.AuthViewModelFactory

@Composable
fun SignIn(navController: NavController, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    // Create UserRepository instance
    val userRepository = UserRepository(
        apiService = RetrofitClient.api, // Adjust according to how you instantiate your API service
        sharedPreferencesManager = SharedPreferencesManager(context)
    )

    // Create the ViewModel using the factory
    val authViewModel: AuthViewModel = viewModel(
        factory = AuthViewModelFactory(userRepository, context)
    )
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val loginState by authViewModel.loginState.collectAsState()
    GradientBackground {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Sign In",
                fontWeight = FontWeight(500),
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(bottom = 64.dp, top = 16.dp)
            )

            Text(
                text = "Speedo Transfer",
                fontWeight = FontWeight(600),
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(bottom = 65.dp)
            )

            CustomTextField(
                header = "Email",
                placeHolder = "Enter your email address",
                icon = ImageVector.vectorResource(id = R.drawable.emailic),
                inputType = KeyboardType.Text,
                textState = emailState,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )

            CustomTextField(
                header = "Password",
                placeHolder = "Enter your password",
                icon = ImageVector.vectorResource(id = R.drawable.eye_compic_1),
                inputType = KeyboardType.Password,
                textState = passwordState,
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
            )



            CustomButton(
                text = "Sign in",
                onClick = {
                    Log.d("trace", "Button clicked:${emailState.value},${passwordState.value}")
                    authViewModel.login(emailState.value, passwordState.value)

                          },
                buttonType = "Filled",
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .height(55.dp)
            )
            when (loginState) {
                true -> {
                    Text("Login successful")
                    LaunchedEffect(Unit) {
                     navController.navigate(Screen.Home.route)
                    }
                }
                false -> Text("Login failed")
                null -> Text("Please enter your credentials")
            }
            Row {
                Text(
                    text = "Don’t have an account? ",
                    color = G100
                )
                Text(
                    text = "Sign Up",
                    color = P300,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                        .clickable {
                            navController.navigate(Screen.Signup.route)
                        }
                )
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SignInpreview() {
    SignIn(navController = rememberNavController())
}