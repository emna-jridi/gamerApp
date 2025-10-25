package tn.esprit.GamerApp.Screens

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import tn.esprit.GamerApp.R
import tn.esprit.GamerApp.ui.theme.GamerAppTheme
import tn.esprit.GamerApp.ui.theme.PrimaryColor

@Composable
fun Login(navController: NavHostController) {
    var email by remember{mutableStateOf("")}
    var mdp by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf(false) }
    var passError by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current


    Column(
        modifier = Modifier
    .fillMaxSize()
    .padding(16.dp),
        horizontalAlignment =Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(R.drawable.logo_gamer),
            contentDescription = "logo",
            modifier = Modifier.size(200.dp).padding(20.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = {email = it
                emailError = !Patterns.EMAIL_ADDRESS.matcher(email).matches()

            },
            label = {Text("Email")},
            modifier = Modifier.
                width(400.dp)
                .padding(16.dp),
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = emailError,



            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFE91E63),
                unfocusedBorderColor = Color.Gray
            ),
            trailingIcon = {
                if (emailError) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "Error",
                        tint = Color.Red
                    )
                }
            }
        )
        if (emailError) {
            Text(
                text = "Invalid email address",
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 16.dp)
            )}
        OutlinedTextField(
            value =mdp ,
            onValueChange = {mdp = it
                passError = mdp.length < 6
            } ,
            label = {Text("Password")},
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
            modifier = Modifier.
            width(400.dp)
                .padding(16.dp,0.dp),

            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (passwordVisible) "Masquer" else "Afficher"
                    )
                }
            },
            )
        if (passError) {
            Text(
                text = ".",
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Row(
            modifier = Modifier.padding(2.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,

        ){
        Row(verticalAlignment = Alignment.CenterVertically
               

        ) {
            Checkbox(
                checked = rememberMe,
                onCheckedChange = { rememberMe = it },
                modifier = Modifier.offset((-4).dp,0.dp )
            )
            Text(text = "Remember Me", color = PrimaryColor,fontSize = 14.sp,  modifier = Modifier.padding(0.dp ,0.dp ,
                30.dp , 0.dp) )
        }

        TextButton( onClick = {
            navController.navigate("forgetPass")

        }
        ) {
            Text("Forgot password ?", color = PrimaryColor , fontSize = 12.sp, )

        }}
        Row {
            Button(
                    onClick = {
                        if(!emailError && !passError){
                            navController.navigate("home")
                        }
                        else{
                            Toast.makeText(context, "Login Failed!", Toast.LENGTH_SHORT).show()
                            email = ""
                            mdp =""
                        }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryColor,
                    contentColor = Color.White
                )
            ) {
                Text("Sign In", color = Color.White)
            }
        }
        Text("OR", style = MaterialTheme.typography.bodyMedium , color = PrimaryColor, modifier = Modifier.padding(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Bouton Facebook
            Button(
                onClick = {   },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1877F2),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_facebook),
                    contentDescription = "Facebook",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Facebook",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            // Bouton Google
            OutlinedButton(
                onClick = {  },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color(0xFFDADADA))
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_google),
                    contentDescription = "Google",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Google",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don't have an account?",
                color = PrimaryColor,
                fontSize = 14.sp
            )
            TextButton(
                onClick = {navController.navigate("SignUp") },
                contentPadding = PaddingValues(horizontal = 4.dp)
            ) {
                Text(
                    text = "Register Now",
                    color = PrimaryColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GamerAppTheme {
        val navController = rememberNavController()
        Login(navController)
    }
}