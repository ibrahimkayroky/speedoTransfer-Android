package com.gradproj.SpeedoTransferApp.ui.features.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gradproj.SpeedoTransferApp.R
import com.gradproj.SpeedoTransferApp.ui.components.ProfileInformationComponent
import com.gradproj.SpeedoTransferApp.ui.viewmodels.UserViewModel

@Composable
fun PersonalInformation(navController: NavController,viewModel: UserViewModel, modifier: Modifier = Modifier) {
    val userData by viewModel.userData.collectAsState()
    val fullName = userData?.name
    val email = userData?.email
    val DOB = userData?.birthDate
    val country = userData?.country
    val bankAccount = "1234xxxx"

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.drop_downic),
                contentDescription = "back",
                modifier = Modifier.clickable { navController.popBackStack() }
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Profile Information",
                fontWeight = FontWeight.W500,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(end = 24.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
        }
        if (fullName != null) {
            ProfileInformationComponent(
                header = "Full Name",
                description = fullName
            )
        }
        if (email != null) {
            ProfileInformationComponent(
                header = "Email",
                description = email
            )
        }
        if (DOB != null) {
            ProfileInformationComponent(
                header = "Date Of Birth",
                description = DOB
            )
        }
        if (country != null) {
            ProfileInformationComponent(
                header = "Country",
                description = country
            )
        }
        ProfileInformationComponent(
            header = "Bank Account",
            description = bankAccount
        )
    }

}
/*

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PersonalInformationPreview() {
    PersonalInformation(navController = rememberNavController(),)
}*/
