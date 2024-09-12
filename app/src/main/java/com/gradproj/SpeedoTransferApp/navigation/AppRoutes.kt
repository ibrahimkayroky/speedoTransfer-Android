package com.gradproj.SpeedoTransferApp.navigation

import SignIn
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.gradproj.SpeedoTransferApp.api.RetrofitClient
import com.gradproj.SpeedoTransferApp.api.UserApiCallable
import com.gradproj.SpeedoTransferApp.prefrences.SharedPreferencesManager
import com.gradproj.SpeedoTransferApp.repository.FavoriteRepository
import com.gradproj.SpeedoTransferApp.repository.TransactionRepository
import com.gradproj.SpeedoTransferApp.repository.TransferRepository
import com.gradproj.SpeedoTransferApp.repository.UserRepository
import com.gradproj.SpeedoTransferApp.ui.features.authentication.SignUp
import com.gradproj.SpeedoTransferApp.ui.features.authentication.SignupContinue
import com.gradproj.SpeedoTransferApp.ui.features.authentication.TimeOut
import com.gradproj.SpeedoTransferApp.ui.features.mainApp.Favourites
import com.gradproj.SpeedoTransferApp.ui.features.mainApp.HomeScreen
import com.gradproj.SpeedoTransferApp.ui.features.mainApp.MoreMenu
import com.gradproj.SpeedoTransferApp.ui.features.mainApp.TransactionsList
import com.gradproj.SpeedoTransferApp.ui.features.mainApp.TransferAmount
import com.gradproj.SpeedoTransferApp.ui.features.mainApp.TransferConfirmation
import com.gradproj.SpeedoTransferApp.ui.features.mainApp.TransferPayment
import com.gradproj.SpeedoTransferApp.ui.features.notification.NotificationScreen
import com.gradproj.SpeedoTransferApp.ui.features.onboarding.OnBoardingAmount
import com.gradproj.SpeedoTransferApp.ui.features.onboarding.OnBoardingConfirmation
import com.gradproj.SpeedoTransferApp.ui.features.onboarding.OnBoardingPayment
import com.gradproj.SpeedoTransferApp.ui.features.profile.ChangePassword
import com.gradproj.SpeedoTransferApp.ui.features.profile.EditProfile
import com.gradproj.SpeedoTransferApp.ui.features.profile.PersonalInformation
import com.gradproj.SpeedoTransferApp.ui.features.profile.Profile
import com.gradproj.SpeedoTransferApp.ui.features.profile.Settings
import com.gradproj.SpeedoTransferApp.ui.viewmodels.AuthViewModel
import com.gradproj.SpeedoTransferApp.ui.viewmodels.AuthViewModelFactory
import com.gradproj.SpeedoTransferApp.ui.viewmodels.FavoriteViewModel
import com.gradproj.SpeedoTransferApp.ui.viewmodels.FavoriteViewModelFactory
import com.gradproj.SpeedoTransferApp.ui.viewmodels.TransViewModel
import com.gradproj.SpeedoTransferApp.ui.viewmodels.TransViewModelFactory
import com.gradproj.SpeedoTransferApp.ui.viewmodels.TransferViewModel
import com.gradproj.SpeedoTransferApp.ui.viewmodels.TransferViewModelFactory
import com.gradproj.SpeedoTransferApp.ui.viewmodels.UserViewModel
import com.gradproj.SpeedoTransferApp.ui.viewmodels.UserViewModelFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch


@Composable
fun Navigation(
    navController: NavHostController,
    isFirstTime: Boolean,
    modifier: Modifier = Modifier
) {

    val userRepository = UserRepository(
        apiService = RetrofitClient.createService(UserApiCallable::class.java),
        sharedPreferencesManager = SharedPreferencesManager(LocalContext.current)
    )
    val UserviewModel: UserViewModel = viewModel(
        factory = UserViewModelFactory(userRepository)
    )

    val transactionRepository = TransactionRepository(
        apiService = RetrofitClient.createService(UserApiCallable::class.java),
        sharedPreferencesManager = SharedPreferencesManager(LocalContext.current)
    )
    val TransViewModel: TransViewModel = viewModel(
        factory = TransViewModelFactory(transactionRepository)
    )

    val transferRepository = TransferRepository(
        apiService = RetrofitClient.createService(UserApiCallable::class.java),
        sharedPreferencesManager = SharedPreferencesManager(LocalContext.current)
    )
    val TransferViewModel: TransferViewModel = viewModel(
        factory = TransferViewModelFactory(transferRepository)
    )

//    val FavoriteRepository = FavoriteRepository(
//        apiService = RetrofitClient.createService(UserApiCallable::class.java),
//        sharedPreferencesManager = SharedPreferencesManager(LocalContext.current)
//    )
//    val FavoriteViewModel: FavoriteViewModel = viewModel(
//        factory = FavoriteViewModelFactory(FavoriteRepository)
//    )

    // Create the ViewModel using the factory
    val authViewModel: AuthViewModel = viewModel(
        factory = AuthViewModelFactory(userRepository,  LocalContext.current)
    )
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
                        navController.navigate(Screen.Signin.route) {
                            popUpTo(0) { inclusive = true }
                        }
                    }
                }
            }


            composable(route = Screen.Signin.route) {

                SignIn(navController,authViewModel)
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
                    ,authViewModel
                )
            }

            composable(route = Screen.Home.route) {
                AppWithInactivityTimeout(navController = navController, viewModel = authViewModel) {

                    HomeScreen(navController, viewModel = UserviewModel, TransViewModel = TransViewModel)
                }
            }


            composable(route = Screen.TransferConfirmation.route + "/{amount}" + "/{name}" + "/{email}",
                arguments = listOf(
                    navArgument("amount") {},
                    navArgument("name") {},
                    navArgument("email") {})
            ) {
                backStackEntry ->
                val amount = backStackEntry.arguments?.getString("amount") ?: ""
                val name = backStackEntry.arguments?.getString("name") ?: ""
                val email = backStackEntry.arguments?.getString("email") ?: ""

                AppWithInactivityTimeout(navController = navController, viewModel=authViewModel) {
                    TransferConfirmation(
                        navController,
                        viewModel = UserviewModel,
                        transferViewModel = TransferViewModel,
                        amount = amount,
                        name = name,
                        email = email
                    )

                }
            }
            composable(route = Screen.TransferAmount.route) {
                AppWithInactivityTimeout(navController = navController, viewModel = authViewModel) {
                    TransferAmount(navController)

                }
            }

            composable(route = Screen.TransferPayment.route + "/{amount}" + "/{name}" + "/{email}",
                arguments = listOf(
                    navArgument("amount") {},
                    navArgument("name") {},
                    navArgument("email") {})
            ) {
                backStackEntry ->
                val amount = backStackEntry.arguments?.getString("amount") ?: ""
                val name = backStackEntry.arguments?.getString("name") ?: ""
                val email = backStackEntry.arguments?.getString("email") ?: ""
                AppWithInactivityTimeout(navController = navController, viewModel = authViewModel) {

                    TransferPayment(
                        navController,
                        viewModel = UserviewModel,
                        amount = amount,
                        name = name,
                        email = email
                    )
                }
            }


            composable(
                route = Screen.MoreMenu.route
            ) {
                AppWithInactivityTimeout(navController = navController, viewModel = authViewModel) {

                    MoreMenu(navController,authViewModel)
                }
            }

            composable(
                route = Screen.Profile.route
            ) {
                AppWithInactivityTimeout(navController = navController, viewModel = authViewModel) {
                    Profile(navController,UserviewModel)

                }
            }

            composable(
                route = Screen.PersonalInformation.route
            ) {
                AppWithInactivityTimeout(navController = navController, viewModel = authViewModel) {
                    PersonalInformation(navController,UserviewModel)
                }
            }

            composable(
                route = Screen.Settings.route
            ) {
                AppWithInactivityTimeout(navController = navController, viewModel = authViewModel) {
                    Settings(navController)
                }
            }

            composable(
                route = Screen.ChangePassword.route
            ) {

                ChangePassword(navController,UserviewModel,authViewModel)
            }

            composable(
                route = Screen.EditProfile.route
            ) {
                EditProfile(navController,UserviewModel)
            }

            composable(
                route = Screen.FavoritesMenu.route
            ) {
                AppWithInactivityTimeout(navController = navController, viewModel = authViewModel) {
                    Favourites(navController)
                }
            }

            composable(
                route = Screen.TransactionsList.route
            ) {
                AppWithInactivityTimeout(navController = navController, viewModel = authViewModel) {
                    TransactionsList(navController,TransViewModel = TransViewModel)
                }
            }

            composable(
                route = Screen.NotificationScreen.route,
                deepLinks = listOf(navDeepLink { uriPattern = "myapp://details" })
            ) { NotificationScreen(navController) }

            composable(route = Screen.OnBoardingAmount.route)
            {
                AppWithInactivityTimeout(navController = navController, viewModel = authViewModel) {
                    OnBoardingAmount(navController)
                }
            }

            composable(route = Screen.OnBoardingConfirmation.route)
            {
                AppWithInactivityTimeout(navController = navController, viewModel = authViewModel) {
                    OnBoardingConfirmation(navController)
                }
            }
            composable(route = Screen.OnBoardingPayment.route)
            {
                AppWithInactivityTimeout(navController = navController, viewModel = authViewModel) {
                    OnBoardingPayment(navController)
                }
            }
            composable(route = Screen.TimeOut.route) {
                AppWithInactivityTimeout(navController = navController, viewModel = authViewModel) {
                    TimeOut(navController,authViewModel)
                }
            }
        }
    }
}


@Composable
fun AppWithInactivityTimeout(
    navController: NavController,
    timeoutDuration: Long =  120000L// 5 seconds for example
    ,viewModel: AuthViewModel
    , content: @Composable () -> Unit
) {
    // Coroutine scope to handle timers
    val scope = rememberCoroutineScope()
    var lastInteractionTime by remember { mutableStateOf(System.currentTimeMillis()) }

    // Start a coroutine that tracks inactivity
    DisposableEffect(Unit) {
        val job = scope.launch {
            while (isActive) {
                if (System.currentTimeMillis() - lastInteractionTime > timeoutDuration) {

                    navController.navigate(Screen.TimeOut.route) {
                        viewModel.logout()
                        popUpTo("mainScreen") { inclusive = true }
                    }
                    break
                }
                delay(1000L) // Check every second
            }
        }
        onDispose { job.cancel() }
    }

    // Detect user interaction across the app
    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures {
                    lastInteractionTime = System.currentTimeMillis()
                }
            }
    ) {
        // Your app content goes here
        content()
    }
}
















