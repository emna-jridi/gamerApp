import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import tn.esprit.GamerApp.Screens.SignUp
import tn.esprit.GamerApp.ui.theme.GamerAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(
    title: String, showCart: Boolean
) {
    TopAppBar(
        title = { Text(title , color = Color.White )  },
        actions = {
            IconButton(onClick = { /* notifications */ }) {
                Icon(Icons.Default.Notifications,
                    contentDescription = "Notifications"
                ,
                    tint = Color.White
                )
            }
            if (showCart) {
                IconButton(onClick = { /* panier */ }) {
                    Icon(Icons.Default.ShoppingCart,
                        contentDescription = "Panier" ,
                        tint = Color.White)
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFE91E63) // pink like your theme
        )
    )
}


@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    GamerAppTheme {
        val navController = rememberNavController()
        MyAppBar("News",true )
    }
}