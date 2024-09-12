package com.gradproj.SpeedoTransferApp.ui.features.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gradproj.SpeedoTransferApp.R
import com.gradproj.SpeedoTransferApp.navigation.Screen

import com.gradproj.SpeedoTransferApp.ui.components.ProfileComponent
import com.gradproj.SpeedoTransferApp.ui.theme.G100
import com.gradproj.SpeedoTransferApp.ui.theme.G40
import com.gradproj.SpeedoTransferApp.ui.viewmodels.UserViewModel

@Composable
fun Profile(navController: NavController, viewModel: UserViewModel,modifier: Modifier = Modifier) {
    val username = viewModel.userData.value?.name ?: ""
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.drop_downic),
                contentDescription = "back",
                modifier = Modifier
                    .clickable {
                        navController.popBackStack()
                    }
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Profile",
                fontWeight = FontWeight.W500,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(end = 24.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(bottom = 32.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(32.dp),
                color = G40,
                modifier = Modifier
                    .padding(end = 16.dp)
            ){
                Text(
                    text = extractFirstLetters(username),
                    fontWeight = FontWeight.W600,
                    fontSize = 20.sp,
                    color = G100,
                    modifier = Modifier.padding(10.dp)
                )
            }

            Text(
                text = username,
                fontWeight = FontWeight.W600,
                fontSize = 20.sp,
            )
        }

        ProfileComponent(
            navController,
            pageToGo = Screen.PersonalInformation.route,
            header = "Personal Information",
            description = "Your Information",
            icon = ImageVector.vectorResource(id = R.drawable.useric),
        )
        ProfileComponent(
            navController,
            pageToGo = Screen.Settings.route,
            header = "Setting",
            description = "Change your settings",
            icon = ImageVector.vectorResource(id = R.drawable.settingic),
            modifier = Modifier.padding(top = 16.dp)
        )
        ProfileComponent(
            navController,
            pageToGo = Screen.TransactionsList.route,
            header = "Payment history",
            description = "view your transactions",
            icon = ImageVector.vectorResource(id = R.drawable.history_1ic),
            modifier = Modifier.padding(top = 16.dp)
        )
        ProfileComponent(
            navController,
            pageToGo = Screen.FavoritesMenu.route,
            header = "My Favourite list",
            description = "view your favourites",
            icon = ImageVector.vectorResource(id = R.drawable.favoriteic),
            modifier = Modifier.padding(top = 16.dp)
        )

        //bottom navbar should be here
    }
}

fun extractFirstLetters(input: String): String {
    return input.split(" ")
        .filter { it.isNotEmpty() }
        .map { it.first().uppercaseChar() }
        .joinToString("")
}
/*

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProfilePreview() {
    Profile(navController = rememberNavController())
}
*/
