package com.gradproj.SpeedoTransferApp.ui.features.notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gradproj.SpeedoTransferApp.R
import com.gradproj.SpeedoTransferApp.ui.components.BottomBar
import com.gradproj.SpeedoTransferApp.ui.components.transferDetails
import com.gradproj.SpeedoTransferApp.ui.theme.G100
import com.gradproj.SpeedoTransferApp.ui.theme.G700
import com.gradproj.SpeedoTransferApp.ui.theme.G900
import com.gradproj.SpeedoTransferApp.ui.theme.P300
import com.gradproj.SpeedoTransferApp.ui.theme.P50

@Composable
fun NotificationScreen(navController: NavController, modifier: Modifier = Modifier) {
Scaffold (
    topBar = {
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
                modifier = modifier
                    .align(Alignment.CenterVertically)
                    .clickable { navController.popBackStack() }
            )

            Text(
                text = "Successful Transactions",
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
    }
    , bottomBar = { BottomBar(navController,"transaction") }
){innerPadding ->
    var senderName :String = "Asmaa Dosuky"
    var senderAccNumber :Int = 6789
    var recipientName :String = "Jonath Smith"
    var recipientAccNumber :Int = 1234
    var amount :Int = 1000
Column(verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.padding(innerPadding).fillMaxSize().padding(end=16.dp,start=16.dp,bottom = 32.dp,top = 32.dp)) {
    Image(painter = painterResource(id = R.drawable.ic_colored_right), contentDescription ="Transaction done" )
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = G900)) {
                append("$amount ")
            }
            withStyle(style = SpanStyle(color = P300)) {
                append("USD")
            }
        },
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold
    )


    Text(
        text = "Transfer amount",
        color =G700,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        modifier = Modifier.padding(top = 4.dp)
    )


    Text(
        text = "Received money",
        color = P300,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        modifier = Modifier.padding(top = 4.dp)
    )

    Spacer(modifier = Modifier.height(16.dp))
    transferDetails(senderName,senderAccNumber,recipientName,recipientAccNumber)
    Spacer(modifier = Modifier.height(16.dp))
    Card( colors = CardDefaults.cardColors(P50),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Reference",
                    color = G700,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
                Text(
                    text = "123456789876",
                    color = G100,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))


            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Date",
                    color = G700,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
                Text(
                    text = "20 Jul 2024 7:50 PM",
                    color = G100,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
            }
        }
    }



}
}
}

@Preview
@Composable
private fun NotificationScreenPreview() {
    NotificationScreen(rememberNavController())
}