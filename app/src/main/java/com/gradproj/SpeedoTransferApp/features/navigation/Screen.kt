package com.gradproj.SpeedoTransferApp.features.navigation

sealed class Screen(val route: String) {
    object Signin : Screen("Signin")
    object Signup : Screen("Signup")
    object SignUpContinue : Screen("SignUpContinue")
    object MoreMenu : Screen("MoreMenu")
    object Profile : Screen("Profile")
    object PersonalInformation : Screen("PersonalInformation")
    object Settings : Screen("Settings")
    object ChangePassword : Screen("ChangePassword")
    object EditProfile : Screen("EditProfile")
    object Home : Screen("Home")
    object TransferAmount : Screen("TransferAmount")
    object TransferPayment : Screen("TransferPayment")
    object TransferConfirmation : Screen("TransferConfirmation")

}