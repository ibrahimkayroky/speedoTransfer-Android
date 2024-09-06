package com.gradproj.SpeedoTransferApp.features.mainApp


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gradproj.SpeedoTransferApp.R
import com.gradproj.SpeedoTransferApp.ui.components.BottonBar
import com.gradproj.SpeedoTransferApp.ui.components.CustomButton
import com.gradproj.SpeedoTransferApp.ui.theme.G40
import com.gradproj.SpeedoTransferApp.ui.theme.G500
import com.gradproj.SpeedoTransferApp.ui.theme.G900
import com.gradproj.SpeedoTransferApp.ui.theme.P300
import com.gradproj.SpeedoTransferApp.ui.theme.P50
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun TransferPayment(modifier: Modifier = Modifier) {
    Scaffold(topBar = {
        TransferPaymentTopBar()

    }, bottomBar = { BottonBar("transfer") }){
            innerPadding ->
        var senderName :String = "Asmaa Dosuky"
        var senderAccNumber :Int = 6789
        var recipientName :String = "Jonath Smith"
        var recipientAccNumber :Int = 1234
        var amount :Int = 1000


        Column( verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .padding(end=16.dp,start=16.dp)
                .fillMaxSize()) {





          Icon(painter = painterResource(id = R.drawable.ic_right_red), contentDescription ="done", tint = Color.Unspecified )
            Text(
                text = "Your transfer was successful",
                fontSize = 20.sp,
                color = G900
            )

            Spacer(modifier = Modifier.weight(1f))


            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    TransferCardDetails(senderName,senderAccNumber,"From")
                    TransferCardDetails(recipientName,recipientAccNumber,"To")
                }
                Icon(
                    painter = painterResource(id = R.drawable.ic_right_yellow),
                    contentDescription = "Transfer Icon",
                    tint = Color.Unspecified
                )
            }
            // Bottom Total Amount Section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Total amount",
                    fontSize = 18.sp,
                    color = Color.Gray
                )
                Text(
                    text = "$amount EGP",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = G500
                )
            }

            // Divider at the bottom
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color.LightGray
            )
            Spacer(modifier = Modifier.height(16.dp))

            CustomButton("Back to Home", {}, "Filled")
            Spacer(modifier = Modifier.height(16.dp))
            CustomButton("Add to Favourite  ", {}, "Outlined")

        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TransferConfirmationPreview() {
    TransferPayment()
}
@Composable
fun TransferPaymentTopBar(modifier: Modifier = Modifier) {
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
                .padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween.also { Alignment.CenterHorizontally }
        ) {

            Icon(
                painter = painterResource(id = R.drawable.drop_downic),
                contentDescription = "back",
                modifier = modifier.align(Alignment.CenterVertically)
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
                .padding(bottom = 18.dp, end = 32.dp, start = 32.dp)
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
                color = P300,
                thickness = 2.dp
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_second_chosen),
                contentDescription = "second",
                tint = Color.Unspecified
            )



            HorizontalDivider(
                modifier = Modifier
                    .height(2.dp)
                    .width(90.dp),
                color = P300,
                thickness = 2.dp
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_third_chosen),
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

