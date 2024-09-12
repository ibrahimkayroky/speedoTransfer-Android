package com.gradproj.SpeedoTransferApp.ui.features.mainApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.waterfall
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.gradproj.SpeedoTransferApp.ui.components.MoreMenuItem
import com.gradproj.SpeedoTransferApp.ui.theme.G40
import com.gradproj.SpeedoTransferApp.ui.theme.G900
import com.gradproj.SpeedoTransferApp.ui.theme.P300
import com.gradproj.SpeedoTransferApp.ui.theme.P50
import com.gradproj.SpeedoTransferApp.ui.viewmodels.AuthViewModel
import com.gradproj.SpeedoTransferApp.ui.viewmodels.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreMenu(navController: NavController, viewModel: AuthViewModel, modifier: Modifier = Modifier) {

    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    if(showBottomSheet)
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState,
            shape = RoundedCornerShape(
                topStart = 50.dp,
                topEnd = 50.dp,
                bottomStart = 0.dp,
                bottomEnd = 0.dp
            ),
            windowInsets = WindowInsets.waterfall,
            containerColor = Color.White
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(64.dp)
            ) {
                Card(
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(Color.White),
                    elevation = CardDefaults.cardElevation(8.dp),
                    modifier = Modifier
                        .width(120.dp)
                        .height(140.dp)

                ){
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.email_card),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(vertical = 15.dp)
                                .size(55.dp)
                        )
                        Text(
                            text = "Send Email",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500,
                            color = G900
                        )
                    }
                }

                Spacer(
                    modifier = Modifier
                        .weight(1f)
                )

                Card(
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(Color.White),
                    elevation = CardDefaults.cardElevation(8.dp),
                    modifier = Modifier
                        .width(120.dp)
                        .height(140.dp)

                ){
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.phone_card),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(vertical = 15.dp)
                                .size(55.dp)
                        )
                        Text(
                            text = "Call Us",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500,
                            color = G900
                        )
                        Text(
                            text = "000000",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500,
                            color = P300
                        )
                    }
                }
            }
        }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(16.dp)
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
                modifier = Modifier
                    .clickable {
                        navController.popBackStack()
                    }
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "More",
                fontWeight = FontWeight.W500,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(end = 36.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        MoreMenuItem(
            itemDescription = "Transfer from website",
            icon = ImageVector.vectorResource(id = R.drawable.websiteic),
            modifier = Modifier
                .clickable {

                }
        )

        MoreMenuItem(
            itemDescription = "Favourites",
            icon = ImageVector.vectorResource(id = R.drawable.favoriteic),
            modifier = Modifier
                .clickable {
                    navController.navigate(Screen.FavoritesMenu.route)
                }
        )

        MoreMenuItem(
            itemDescription = "Profile",
            icon = ImageVector.vectorResource(id = R.drawable.useric),
            modifier = Modifier
                .clickable {
                    navController.navigate(Screen.Profile.route)
                }
        )

        MoreMenuItem(
            itemDescription = "Help",
            icon = ImageVector.vectorResource(id = R.drawable.fillic),
            modifier = Modifier
                .clickable {
                    showBottomSheet = true
                }
        )

        MoreMenuItem(
            itemDescription = "Logout",
            icon = ImageVector.vectorResource(id = R.drawable.logoutic),
            modifier = Modifier
                .clickable {
                   viewModel.logout()
                    navController.navigate(Screen.Signin.route)
                }
        )

    }

}
/*

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MoreMenuPreview() {
    MoreMenu(navController = rememberNavController())
}*/
