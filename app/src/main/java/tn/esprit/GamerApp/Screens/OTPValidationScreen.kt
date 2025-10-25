package tn.esprit.GamerApp.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
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
fun OTPScreen(navController: NavHostController) {
    var otp1 by remember { mutableStateOf("") }
    var otp2 by remember { mutableStateOf("") }
    var otp3 by remember { mutableStateOf("") }
    var otp4 by remember { mutableStateOf("") }
    val focus1 = remember { FocusRequester() }
    val focus2 = remember { FocusRequester() }
    val focus3 = remember { FocusRequester() }
    val focus4 = remember { FocusRequester() }
    val snackbarHostState = remember { SnackbarHostState() }
    val enteredCode = otp1 + otp2 + otp3 + otp4

    val scope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    "Enter the code sent to you by\nEmail or Mobile number",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(start = 16.dp, top = 40.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 30.dp , top = 30.dp)
                ) {
                    // OTP1
                    OutlinedTextField(
                        value = otp1,
                        onValueChange = {
                            if (it.matches(Regex("[0-9]?"))) {
                                otp1 = it
                                if (it.isNotEmpty()) focus2.requestFocus()
                            }
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .width(55.dp)
                            .height(55.dp)
                            .focusRequester(focus1)
                    )

                    // OTP2
                    OutlinedTextField(
                        value = otp2,
                        onValueChange = {
                            if (it.matches(Regex("[0-9]?"))) {
                                otp2 = it
                                if (it.isNotEmpty()) focus3.requestFocus()
                            }
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .width(55.dp)
                            .height(55.dp)
                            .focusRequester(focus2)
                    )

                    // OTP3
                    OutlinedTextField(
                        value = otp3,
                        onValueChange = {
                            if (it.matches(Regex("[0-9]?"))) {
                                otp3 = it
                                if (it.isNotEmpty()) focus4.requestFocus()
                            }
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .width(55.dp)
                            .height(55.dp)
                            .focusRequester(focus3)
                    )

                    // OTP4
                    OutlinedTextField(
                        value = otp4,
                        onValueChange = {
                            if (it.matches(Regex("[0-9]?"))) {
                                otp4 = it
                            }
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .width(55.dp)
                            .height(55.dp)
                            .focusRequester(focus4)
                    )
                }

                Button(
                    onClick = {
                        val enteredCode = otp1 + otp2 + otp3 + otp4
                        if (enteredCode == "1234" || enteredCode == "6789") {
                            navController.navigate("resetpwd")
                        } else {
                            scope.launch {
                                snackbarHostState.showSnackbar("Code incorrect")
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 60.dp)
                        .height(56.dp),

                    shape = RoundedCornerShape(28.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF1744)
                    )
                )
                {
                    Text(
                        text = "Verify",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(
                    text = "Didn't receive a verification code?",
                    modifier = Modifier.offset(50.dp, 20.dp),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                )
                TextButton(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("Coming soon")
                        }
                    },
                    modifier = Modifier.offset(110.dp, 20.dp),

                    ) {
                    Text(
                        text = "Resend code",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFF1744)
                        )
                    )
                }

            }
        }
    }}
@Preview(showBackground = true)
@Composable
fun OTPScreenPreview() {
    GamerAppTheme {
        val navController = rememberNavController()
        OTPScreen(navController)
    }
}