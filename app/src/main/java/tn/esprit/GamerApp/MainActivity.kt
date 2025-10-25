package tn.esprit.GamerApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tn.esprit.GamerApp.Screens.ForgotPassword
import tn.esprit.GamerApp.Screens.ForgotPasswordPreview
import tn.esprit.GamerApp.Screens.Home
import tn.esprit.GamerApp.Screens.Login
import tn.esprit.GamerApp.Screens.OTPScreen
import tn.esprit.GamerApp.Screens.ResetPassword
import tn.esprit.GamerApp.Screens.SignUp
import tn.esprit.GamerApp.ui.theme.GamerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GamerAppTheme {
                Surface {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            Login(navController = navController)
        }
        composable("home") {
            Home(navController = navController)
        }
        composable("signup") {
            SignUp(navController = navController)
        }
        composable("forgetPass") {
            ForgotPassword(navController)
        }
        composable ("otp/{code}") {
            OTPScreen(navController)
        }
        composable("resetpwd") {
            ResetPassword()
        }
    }
}