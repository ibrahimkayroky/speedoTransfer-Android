package com.gradproj.SpeedoTransferApp.features.authentication



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gradproj.SpeedoTransferApp.R
import com.gradproj.SpeedoTransferApp.ui.components.CustomButton
import com.gradproj.SpeedoTransferApp.ui.components.GradientBackground
import com.gradproj.SpeedoTransferApp.ui.theme.G100
import com.gradproj.SpeedoTransferApp.ui.theme.G900
import com.gradproj.SpeedoTransferApp.ui.theme.P300
import com.gradproj.SpeedoTransferApp.ui.components.CustomTextField as CustomTextField1


@Composable
fun SignupContinue(modifier: Modifier = Modifier) {
    GradientBackground {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxWidth()
        ) {
            Icon(painter = painterResource(id = R.drawable.drop_downic), contentDescription = "back",modifier = Modifier.align(Alignment.Start))
            Text(
                text = "Speedo Transfer",
                fontWeight = FontWeight(600),
                fontSize = 24.sp,
                color = G900,
                modifier = Modifier
                    .padding(bottom = 64.dp, top = 64.dp)
            )
            Column( horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.fillMaxWidth()) {
                Text(
                    text = "Welcome to Banque Misr!",
                    fontWeight = FontWeight(600),
                    color = G900,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(bottom = 8.dp, top = 8.dp)

                )
                Text(
                    text = "Let’s Complete your Profile",
                    fontWeight = FontWeight(400),
                    color = G900,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(bottom = 8.dp, top = 8.dp)
                )
            }

            CustomTextField1(
                header = "Country",
                placeHolder = "Select your country",
                icon = ImageVector.vectorResource(id = R.drawable.drop_downic),
                inputType = KeyboardType.Text,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )
            CustomTextField1(
                header = "Date Of Brith",
                placeHolder = "DD/MM/YYY",
                icon = ImageVector.vectorResource(id = R.drawable.dateic),
                inputType = KeyboardType.Text,
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
            )
            CustomButton(
                text = "Continue",
                onClick = {},
                buttonType = "Filled",
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .height(55.dp)
            )

            Row {
                Text(text = "Already have an account? ", color = G100)
                Text(text = "Sign in", color = P300, textDecoration = TextDecoration.Underline)
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun  SignupContinuePreview() {
    SignupContinue()
}