package com.gradproj.SpeedoTransferApp.features.navigation

sealed class Screen(val route: String) {
    object Signin : Screen("Signin")
    object Signup : Screen("Signup")
    object SignUpContinue : Screen("SignUpContinue")
    object Profile : Screen("Profile")
    object PersonalInformation : Screen("PersonalInformation")
}