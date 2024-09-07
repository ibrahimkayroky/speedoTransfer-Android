package com.gradproj.SpeedoTransferApp.features.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gradproj.SpeedoTransferApp.R
import com.gradproj.SpeedoTransferApp.features.navigation.Screen
import com.gradproj.SpeedoTransferApp.ui.components.CustomButton
import com.gradproj.SpeedoTransferApp.ui.theme.G700
import com.gradproj.SpeedoTransferApp.ui.theme.G900

@Composable
fun OnBoardingConfirmation(navController: NavController) {
    // Root container
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Skip Button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = { navController.navigate(Screen.Signin.route) }) {
                Text("Skip", color =G900)
            }
        }

        // Image at the center
        Image(
            painter = painterResource(id = R.drawable.confirmation),
            contentDescription = "Runner Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )


        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.wrapContentWidth()
        ) {
            Image(painter = painterResource(id = R.drawable.circle_light_red), contentDescription ="" )
            Spacer(modifier = Modifier.width(8.dp))
            Image(painter = painterResource(id = R.drawable.circle_red), contentDescription ="" )
            Spacer(modifier = Modifier.width(8.dp))
            Image(painter = painterResource(id = R.drawable.circle_light_red), contentDescription ="" )
        }
        // Text Section
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Confirmation",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
                ,color = G900
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Transfer funds instantly to friends and family worldwide, strong shield protecting a money.",
                fontSize = 16.sp,
                color = G700,
                modifier = Modifier.padding(horizontal = 16.dp),
                lineHeight = 20.sp
            )
        }


        CustomButton("Next", onClick = { navController.navigate(Screen.OnBoardingPayment.route) }, buttonType = "Filled")
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun OnBoardingConfirmationprev() {
    OnBoardingConfirmation(rememberNavController())
}