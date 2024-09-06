package com.gradproj.SpeedoTransferApp.features.navigation

sealed class Screen(val route: String) {
    object Signin : Screen("Signin")
    object Signup : Screen("Signup")
    object SignUpContinue : Screen("SignUpContinue")
    object Home : Screen("Home")
    object TransferAmount : Screen("TransferAmount")
    object TransferPayment : Screen("TransferPayment")
    object TransferConfirmation : Screen("TransferConfirmation")


}