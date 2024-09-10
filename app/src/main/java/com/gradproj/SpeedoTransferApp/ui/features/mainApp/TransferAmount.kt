package com.gradproj.SpeedoTransferApp.ui.features.mainApp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gradproj.SpeedoTransferApp.R
import com.gradproj.SpeedoTransferApp.navigation.Screen

import com.gradproj.SpeedoTransferApp.ui.components.BottomBar
import com.gradproj.SpeedoTransferApp.ui.components.CustomButton
import com.gradproj.SpeedoTransferApp.ui.components.GradientBackground2
import com.gradproj.SpeedoTransferApp.ui.theme.G0
import com.gradproj.SpeedoTransferApp.ui.theme.G70
import com.gradproj.SpeedoTransferApp.ui.theme.G700
import com.gradproj.SpeedoTransferApp.ui.theme.G900
import com.gradproj.SpeedoTransferApp.ui.theme.P300

@Composable
fun TransferAmount(navController: NavController, modifier: Modifier = Modifier) {
    GradientBackground2 {
        Scaffold(topBar = {
            AmountTopBar(navController)
        }, bottomBar = { BottomBar(navController,"transfer") }) { innerPadding ->
            var amount = 1000
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                Text(
                    text = "How much are you sending?",
                    color = G900,
                    fontWeight = FontWeight(600),
                    fontSize = 24.sp, modifier = Modifier.padding(bottom = 24.dp)
                )
                Card(
                    colors = CardDefaults.cardColors(containerColor = G0),
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Start)
                ) {
                    Text(
                        text = "Amount",
                        color = G700,
                        modifier = Modifier
                            .padding(start = 8.dp, end = 8.dp, top = 16.dp)
                            .align(Alignment.Start)
                    )
                    OutlinedTextField(
                        value = amount.toString(),

                        onValueChange = {},
                        modifier = modifier.padding(
                            start = 8.dp,
                            end = 8.dp,
                            top = 16.dp,
                            bottom = 8.dp
                        )
                    )
                }
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, bottom = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Recipient Information",
                        color = G700,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {
                            //open dialog
                        }) {
                        Icon(
                            painter = painterResource(id = R.drawable.favoriteic),
                            contentDescription = "favourites",
                            tint = P300
                        )
                        Text(
                            text = "Favourite",
                            color = P300,
                            fontWeight = FontWeight(500),
                            fontSize = 16.sp
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.drop_downic),
                            contentDescription = "drop down",
                            tint = P300,
                            modifier = Modifier.graphicsLayer(scaleX = -1f)
                        )
                    }


                }
                Text(
                    text = "Recipient Name",
                    color = G700,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.Start)
                )
                // Recipient Name
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Enter Recipient Name",color = G70) },
                    placeholder = { Text(text = "Enter Recipient Name",color = G70) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp).background(G0)
                )
                Text(
                    text = "Recipient Account",
                    color = G700,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.Start)
                )
                // Recipient Account
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Enter Recipient Account Number",color = G70) },
                    placeholder = { Text(text = "Enter Recipient Account Number",color = G70) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp).background(G0)
                )
                CustomButton("Continue", { navController.navigate(Screen.TransferConfirmation.route) }, "Filled",)

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TransferAmountPreview() {
    TransferAmount(rememberNavController())
}

@Composable
fun AmountTopBar(navController: NavController,modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween.also { Alignment.CenterHorizontally }
        ) {

            Icon(
                painter = painterResource(id = R.drawable.drop_downic),
                contentDescription = "back",
                modifier = modifier.align(Alignment.CenterVertically).clickable { navController.popBackStack() }
            )

            Text(
                text = "Transfer",
                color = G900,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight(500),
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    .padding(end = 32.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 18.dp, end = 32.dp,start = 32.dp)
                ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween.also { Alignment.CenterHorizontally }
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_first),
                contentDescription = "first",
                tint = Color.Unspecified
            )



            HorizontalDivider(
                modifier = Modifier
                    .height(2.dp)
                    .width(90.dp),
                color = Color(0xFFA3AAB2),
                thickness = 2.dp
            )

                Icon(
                    painter = painterResource(id = R.drawable.ic_second_unchecked),
                    contentDescription = "second",
                    tint = Color.Unspecified
                )



            HorizontalDivider(
                modifier = Modifier
                    .height(2.dp)
                    .width(90.dp),
                color = Color(0xFFA3AAB2),
                thickness = 2.dp
            )

                Icon(
                    painter = painterResource(id = R.drawable.ic_third_unchecked),
                    contentDescription = "third",
                    tint = Color.Unspecified
                )





        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp, ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Amount",
                color = G900,
                maxLines = 1,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.weight(0.5f))
            Text(
                text = "Confirmation",
                color = G900,
                maxLines = 1,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.weight(0.5f))
            Text(
                text = "Payment",
                color = G900,
                maxLines = 1,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
        }

    }
}