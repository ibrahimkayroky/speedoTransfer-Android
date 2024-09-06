package com.gradproj.SpeedoTransferApp.features.navigation

import SignIn
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gradproj.SpeedoTransferApp.features.authentication.SignUp
import com.gradproj.SpeedoTransferApp.features.authentication.SignupContinue
import com.gradproj.SpeedoTransferApp.features.mainApp.HomeScreen
import com.gradproj.SpeedoTransferApp.features.mainApp.TransferAmount
import com.gradproj.SpeedoTransferApp.features.mainApp.TransferConfirmation
import com.gradproj.SpeedoTransferApp.features.mainApp.TransferPayment

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Column( modifier = modifier) {
        NavHost(navController = navController, startDestination = Screen.Signin.route) {
            composable(route = Screen.Signin.route) {
                SignIn(navController)
            }

            composable(
                route = Screen.Signup.route
            ) {
                SignUp(navController)
            }

            composable(
                route = Screen.SignUpContinue.route + "/{name}" + "/{email}" + "/{password}",
                arguments = listOf(
                    navArgument("name") {},
                    navArgument("email") {},
                    navArgument("password") {}
                )
            ) { entry ->
                SignupContinue(
                    navController,
                    entry.arguments?.getString("name"),
                    entry.arguments?.getString("email"),
                    entry.arguments?.getString("password")
                )
            }

            composable(route = Screen.Home.route) {
                HomeScreen(navController)
            }

            composable(route = Screen.TransferConfirmation.route) {
                TransferConfirmation(navController)
            }
            composable(route = Screen.TransferAmount.route) {
                TransferAmount(navController)
            }
            composable(route = Screen.TransferPayment.route) {
                TransferPayment(navController)
            }

        }
    }
}















