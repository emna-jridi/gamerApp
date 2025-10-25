package tn.esprit.GamerApp.Screens

import android.util.Patterns
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import tn.esprit.GamerApp.ui.theme.GamerAppTheme

@Composable
fun ForgotPassword(navController: NavHostController){
    var email by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf(false) }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val isEmailValid = !emailError && email.isNotEmpty()


    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start

    ){
        Text("Forgot Password",  style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 16.dp,top = 40.dp )
        )
        Text ("Please enter your registered email to reset your password",
             style = MaterialTheme.typography.bodyMedium,
             color = Color.Gray,
            modifier = Modifier.padding(start = 20.dp,top = 10.dp )
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it
                emailError = !Patterns.EMAIL_ADDRESS.matcher(email).matches()
            },
            label = { Text("Email") },
            modifier = Modifier.width(400.dp)
                .padding(16.dp, 16.dp),
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


        Button(
            onClick = {
                if (isEmailValid) {
                    navController.navigate("otp/1234")
                } else {
                    scope.launch {
                        snackbarHostState.showSnackbar("Veuillez entrer un email valide.")
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp , vertical = 40.dp)
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

        Text("OR", modifier = Modifier.offset(170.dp, 40.dp) ,
            color = Color(0xFFE91E63))

        Button(
            onClick = {
                navController.navigate("otp/6789")

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp , vertical = 100.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE91E63)
            ),
            shape = RoundedCornerShape(25.dp)
        )
        {
            Text(
                text = "Send SMS",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }





}}}




@Preview(showBackground = true)
@Composable
fun ForgotPasswordPreview() {
    GamerAppTheme {
        val navController = rememberNavController()
          ForgotPassword(navController)
    }
}