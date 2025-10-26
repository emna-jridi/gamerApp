package tn.esprit.GamerApp

import MyAppBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import tn.esprit.GamerApp.Screens.*
import tn.esprit.GamerApp.ui.theme.GamerAppTheme
import tn.esprit.GamerApp.utils.MyBottomBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GamerAppTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "login"

    // Define screens that should show AppBar and BottomBar
    val screensWithBars = listOf("home", "store", "profile")
    val showBars = currentRoute in screensWithBars

    // Get display title for current screen
    val screenTitle = when(currentRoute) {
        "home" -> "News"
        "store" -> "Store"
        "profile" -> "Profile"
        else -> ""
    }

    Scaffold(
        topBar = {
            if (showBars) {
                MyAppBar(
                    title = screenTitle,
                    showCart = currentRoute == "store"
                )
            }
        },
        bottomBar = {
            if (showBars) {
                MyBottomBar(
                    navController = navController,
                    currentScreen = currentRoute
                )
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = "login"
            ) {
                composable("login") {
                    Login(navController = navController)
                }
                composable("home") {
                    GameListScreen()
                }
                composable("signup") {
                    SignUp(navController = navController)
                }
                composable("forgetPass") {
                    ForgotPassword(navController)
                }
                composable("otp/{code}") {
                    OTPScreen(navController)
                }
                composable("resetpwd") {
                    ResetPassword(navController)
                }
                // Add other screens that should have bottom bar
                composable("store") {
                    StoreListScreen()
                }
                composable("profile") {
                    ProfileScreen()
                }

            }
        }
    }
}