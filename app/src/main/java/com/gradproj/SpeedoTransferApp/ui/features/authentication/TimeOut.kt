package com.gradproj.SpeedoTransferApp.ui.features.authentication

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gradproj.SpeedoTransferApp.R

import com.gradproj.SpeedoTransferApp.api.RetrofitClient
import com.gradproj.SpeedoTransferApp.navigation.Screen
import com.gradproj.SpeedoTransferApp.prefrences.SharedPreferencesManager
import com.gradproj.SpeedoTransferApp.repository.UserRepository
import com.gradproj.SpeedoTransferApp.ui.components.CustomButton
import com.gradproj.SpeedoTransferApp.ui.components.CustomTextField
import com.gradproj.SpeedoTransferApp.ui.components.GradientBackground
import com.gradproj.SpeedoTransferApp.ui.theme.G40
import com.gradproj.SpeedoTransferApp.ui.theme.G500
import com.gradproj.SpeedoTransferApp.ui.theme.G900
import com.gradproj.SpeedoTransferApp.ui.viewmodels.AuthViewModel

import com.gradproj.SpeedoTransferApp.ui.viewmodels.AuthViewModelFactory
import kotlinx.coroutines.launch

@Composable
fun TimeOut(navController: NavController, viewModel: AuthViewModel, modifier: Modifier = Modifier) {

    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val loginState by viewModel.loginState.collectAsState()

        val scope = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }
        LaunchedEffect(Unit) {
            scope.launch {
                snackbarHostState.showSnackbar("Welcome back! Please sign in.",

                    withDismissAction = true, actionLabel = "Dismiss",
                    duration= SnackbarDuration.Indefinite)
            }
        }
    GradientBackground {
        Scaffold(
            snackbarHost = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .absolutePadding(8.dp).offset(y=16.dp).width(300.dp).height(200.dp),
                    contentAlignment = Alignment.TopCenter
                ) {
                    SnackbarHost(hostState = snackbarHostState, snackbar = {
                        Row (horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically, modifier = modifier
                            .background(G40)
                            .fillMaxWidth()){
                            Icon(
                                painter = painterResource(id = R.drawable.error_ic),
                                contentDescription = "Warning",modifier = Modifier.align(Alignment.CenterVertically)

                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = "We Logged you out because you were \n inactive for 2 minutes - it’s to help your \n account secure ",
                                 fontWeight = FontWeight(500), fontSize = 12.sp, color = G500, textAlign = TextAlign.Center,maxLines =3,overflow = TextOverflow.Ellipsis,
                                lineHeight = 18.sp,
                                modifier = Modifier.align(Alignment.CenterVertically),

                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            snackbarHostState.currentSnackbarData?.visuals?.actionLabel?.let {
                              Icon(painter = painterResource(id = R.drawable.close_ic), contentDescription = "dismsis",modifier=modifier.clickable { snackbarHostState.currentSnackbarData?.performAction()  })
                            }
                        }
                    })
                }
            },

        ) { contentPadding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(contentPadding)
                    .absoluteOffset(y = 200.dp)
            ) {

                Text(
                    text = "Welcome Back",
                    fontWeight = FontWeight(600),
                    color = G900,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(bottom = 8.dp, top = 8.dp)

                )
                Text(
                    text = "Login to your account",
                    fontWeight = FontWeight(400),
                    color = G900,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(bottom = 8.dp, top = 8.dp)
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
                    onClick = {  Log.d("trace", "Button clicked:${emailState.value},${passwordState.value}")
                        viewModel.login(emailState.value, passwordState.value)
                    },
                    buttonType = "Filled",
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .height(55.dp)
                    ,
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

            }
            // Screen content
        }
    }
}


/*

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SignInpreview() {
    TimeOut(rememberNavController())
}*/
