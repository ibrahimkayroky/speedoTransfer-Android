import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gradproj.SpeedoTransferApp.R
import com.gradproj.SpeedoTransferApp.features.navigation.Screen
import com.gradproj.SpeedoTransferApp.ui.components.CustomButton
import com.gradproj.SpeedoTransferApp.ui.components.CustomTextField
import com.gradproj.SpeedoTransferApp.ui.components.GradientBackground
import com.gradproj.SpeedoTransferApp.ui.theme.G100
import com.gradproj.SpeedoTransferApp.ui.theme.P300

@Composable
fun SignIn(navController: NavController, modifier: Modifier = Modifier) {

    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    GradientBackground {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {

        Text(
            text = "Sign In",
            fontWeight = FontWeight(500),
            fontSize = 20.sp,
            modifier = Modifier
                .padding(bottom = 64.dp, top = 16.dp)
        )

        Text(
            text = "Speedo Transfer",
            fontWeight = FontWeight(600),
            fontSize = 24.sp,
            modifier = Modifier
                .padding(bottom = 65.dp)
        )



        CustomTextField(
            header = "Email",
            placeHolder = "Enter your email address",
            icon = ImageVector.vectorResource(id = R.drawable.emailic),
            inputType = KeyboardType.Text,
            textState = emailState,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        )

        CustomTextField(
            header = "Password",
            placeHolder = "Enter your password",
            icon = ImageVector.vectorResource(id = R.drawable.eye_compic_1),
            inputType = KeyboardType.Password,
            textState = passwordState,
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )



        CustomButton(
            text = "Sign in",
            onClick = {},
            buttonType = "Filled",
            modifier = Modifier
                .padding(bottom = 16.dp)
                .height(55.dp)
        )

        Row {
            Text(text = "Don’t have an account? ",
                color = G100
            )
            Text(
                text = "Sign Up",
                color = P300,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screen.Signup.route)
                    }
            )
        }
    }
}
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SignInpreview() {
    SignIn(navController = rememberNavController())
}