package tn.esprit.GamerApp.Screens

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tn.esprit.GamerApp.R
import tn.esprit.GamerApp.ui.theme.GamerAppTheme
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun SignUp(navController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confPass by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf(false) }
    var passError by remember { mutableStateOf(false) }
    var passConfError by remember { mutableStateOf(false) }
    var isError by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var confPasswordVisible by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(R.drawable.logo_gamer),
            contentDescription = "logo",
            modifier = Modifier.size(200.dp).padding(20.dp)
        )
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
                isError = !name.contains(" ") && name.length < 3

            },
            label = { Text("FullName") },
            modifier = Modifier.width(400.dp)
                .padding(16.dp),
            leadingIcon = { Icon(Icons.Default.AccountCircle, contentDescription = null) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFE91E63),
                unfocusedBorderColor = Color.Gray
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            isError = isError,
            trailingIcon = {
                if (isError) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "Error",
                        tint = Color.Red
                    )
                }
            }

        )
        if (isError) {
            Text(
                text = "Please enter your full name (first and last name).",
                color = Color.Red,
                fontSize = 12.sp,
                //modifier = Modifier.padding(start = 16.dp, top = 2.dp)
            )}
            OutlinedTextField(
                value = email,
                onValueChange = { email = it
                    emailError = !Patterns.EMAIL_ADDRESS.matcher(email).matches()
                },
                label = { Text("Email") },
                modifier = Modifier.width(400.dp)
                    .padding(16.dp, 0.dp),
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFE91E63),
                    unfocusedBorderColor = Color.Gray
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                isError = emailError,
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
                value = password,
                onValueChange = {password = it
                    passError = password.length < 6
                    passConfError = confPass != password
                                },
                label = { Text("Password") },
                modifier = Modifier.width(400.dp)
                    .padding(16.dp, 16.dp),
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFE91E63),
                    unfocusedBorderColor = Color.Gray
                ),

                visualTransformation = if (passwordVisible) VisualTransformation.None
                else PasswordVisualTransformation(),
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
                text = "Password must be at least 6 characters.",
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
            OutlinedTextField(
                value = confPass,
                onValueChange = {confPass =  it
                    passConfError = confPass != password                                 },
                label = { Text("Confirm password ") },
                modifier = Modifier.width(400.dp)
                    .padding(16.dp, 0.dp),
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFE91E63),
                    unfocusedBorderColor = Color.Gray
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = if (passwordVisible) "Masquer" else "Afficher"
                        )
                    }
                },
                visualTransformation = if (confPasswordVisible) VisualTransformation.None
                else PasswordVisualTransformation(),

                )
        if (passConfError) {
            Text(
                text = " confirm Password  must be same as Password.",
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

            Spacer(modifier = Modifier.height(33.dp))

            Button(
                onClick = {
                    if(!emailError && !passError  ){
                        navController.navigate("home")

                    }
                    else{
                        Toast.makeText(context, "Login Failed!", Toast.LENGTH_SHORT).show()
                        email = ""
                        password =""
                    }
                    },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE91E63)
                ),
                shape = RoundedCornerShape(25.dp)
            )
            {
                Text(
                    text = "Submit",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = "By registering you accept our Terms &\nCondition and Privacy Policy",
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.offset(0.dp, 20.dp)
            )
        }

    }



@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    GamerAppTheme {
        val navController = rememberNavController()
        SignUp(navController)
    }
}