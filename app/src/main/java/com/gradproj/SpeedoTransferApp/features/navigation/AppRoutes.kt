package com.gradproj.SpeedoTransferApp.features.navigation

import SignIn
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.gradproj.SpeedoTransferApp.features.authentication.SignUp
import com.gradproj.SpeedoTransferApp.features.authentication.SignupContinue
import com.gradproj.SpeedoTransferApp.features.mainApp.Favourites
import com.gradproj.SpeedoTransferApp.features.authentication.TimeOut
import com.gradproj.SpeedoTransferApp.features.mainApp.MoreMenu
import com.gradproj.SpeedoTransferApp.features.profile.ChangePassword
import com.gradproj.SpeedoTransferApp.features.profile.EditProfile
import com.gradproj.SpeedoTransferApp.features.profile.PersonalInformation
import com.gradproj.SpeedoTransferApp.features.profile.Profile
import com.gradproj.SpeedoTransferApp.features.profile.Settings

import com.gradproj.SpeedoTransferApp.features.mainApp.HomeScreen
import com.gradproj.SpeedoTransferApp.features.mainApp.TransactionsList
import com.gradproj.SpeedoTransferApp.features.mainApp.TransferAmount
import com.gradproj.SpeedoTransferApp.features.mainApp.TransferConfirmation
import com.gradproj.SpeedoTransferApp.features.mainApp.TransferPayment
import com.gradproj.SpeedoTransferApp.features.notification.NotificationScreen
import com.gradproj.SpeedoTransferApp.features.onboarding.OnBoardingAmount
import com.gradproj.SpeedoTransferApp.features.onboarding.OnBoardingConfirmation
import com.gradproj.SpeedoTransferApp.features.onboarding.OnBoardingPayment

@Composable
fun Navigation(navController: NavHostController, isFirstTime: Boolean, modifier: Modifier = Modifier) {
    //val navController = rememberNavController()
    Column(modifier = modifier) {
        NavHost(navController = navController, startDestination = Screen.FirstScreen.route) {
            composable(Screen.FirstScreen.route) {
                LaunchedEffect(Unit) {
                    if (isFirstTime) {
                        navController.navigate(Screen.OnBoardingAmount.route) {
                            popUpTo(0) { inclusive = true }
                        }
                    } else {
                        navController.navigate(Screen.Signin.route) {popUpTo(0) { inclusive = true }
                        }
                    }
                }
            }


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


            composable(
                route = Screen.MoreMenu.route
            ) {
                MoreMenu(navController)
            }

            composable(
                route = Screen.Profile.route
            ) {
                Profile(navController)
            }

            composable(
                route = Screen.PersonalInformation.route){
                PersonalInformation(navController)
            }

            composable(
                route = Screen.Settings.route
            ) {
                Settings(navController)
            }

            composable(
                route = Screen.ChangePassword.route){
                ChangePassword(navController)
            }

            composable(
                route = Screen.EditProfile.route){
                EditProfile(navController)
            }

            composable(
                route = Screen.FavoritesMenu.route
            ) {
                Favourites(navController)
            }

            composable(
                route = Screen.TranscationsList.route
            ) {
                TransactionsList(navController)
            }

            composable(
                route = Screen.NotificationScreen.route,
                deepLinks = listOf(navDeepLink { uriPattern = "myapp://details" })
            ) { NotificationScreen(navController) }

            composable(route = Screen.OnBoardingAmount.route)
            { OnBoardingAmount(navController) }

            composable(route = Screen.OnBoardingConfirmation.route)
            { OnBoardingConfirmation(navController) }
            composable(route = Screen.OnBoardingPayment.route)
            { OnBoardingPayment(navController) }

        }
    }
}















