package tn.esprit.GamerApp.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonPin
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import tn.esprit.GamerApp.Screens.SignUp
import tn.esprit.GamerApp.ui.theme.GamerAppTheme

@Composable
fun MyBottomBar(navController: NavHostController,currentScreen: String) {
    NavigationBar(containerColor = Color(0xFFE91E63)) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Newspaper, contentDescription = "Home"
                , tint = Color.White) },
            label = { Text("News" , color = Color.White)  },
            selected = currentScreen == "News",
            onClick = { navController.navigate("home")}
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Store, contentDescription = "Profile"
                , tint = Color.White) },
            label = { Text("Store" , color = Color.White) },
            selected = currentScreen == "store",
            onClick = { navController.navigate("store") }
        )
        this.NavigationBarItem(
            icon = { Icon(Icons.Default.PersonPin, contentDescription = "Settings"
                , tint = Color.White) },
            label = { Text("Profile", color = Color.White) },
            selected = currentScreen == "profile",
            onClick = { navController.navigate("profile") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyBottomBarPreview() {
    GamerAppTheme {
        val navController = rememberNavController()
    //    MyBottomBar("news", {})
    }
}