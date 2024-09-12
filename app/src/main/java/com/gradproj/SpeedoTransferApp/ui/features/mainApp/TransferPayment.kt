package com.gradproj.SpeedoTransferApp.ui.features.mainApp


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import com.gradproj.SpeedoTransferApp.ui.components.TransferCardDetails
import com.gradproj.SpeedoTransferApp.ui.components.transferDetails
import com.gradproj.SpeedoTransferApp.ui.features.notification.sendNotification
import com.gradproj.SpeedoTransferApp.ui.theme.G500
import com.gradproj.SpeedoTransferApp.ui.theme.G900
import com.gradproj.SpeedoTransferApp.ui.theme.P300
import com.gradproj.SpeedoTransferApp.ui.viewmodels.UserViewModel

@Composable
fun TransferPayment(navController: NavController, viewModel: UserViewModel, name:String, email:String, amount:String, modifier: Modifier = Modifier) {
    val userData by viewModel.userData.collectAsState()

    Scaffold(topBar = {
        TransferPaymentTopBar(navController)

    }, bottomBar = { BottomBar(navController,"transfer") }){
            innerPadding ->
        var senderName :String = "${userData?.name}"
        var senderAccNumber :Int = 3214
        var recipientName :String = name
        var recipientAccNumber :Int = 5327
        var amount :String = amount
        var context = LocalContext.current

        Column( verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()) {


          Image(painter = painterResource(id = R.drawable.ic_right_red), contentDescription ="done", contentScale = ContentScale.Crop, )
            Text(
                text = "Your transfer was successful",
                fontSize = 16.sp,
                color = G900
            )




            transferDetails(senderName,senderAccNumber,recipientName,recipientAccNumber)
            // Bottom Total Amount Section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
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



           CustomButton("Back to Home", {
               sendNotification("Complete Transaction","Your transfer was successful",R.drawable.error_ic,context)
               navController.navigate(Screen.Home.route)}, "Filled")
            Spacer(modifier = Modifier.height(16.dp))

            CustomButton("Add to Favourite", {}, "Outlined")

        }

    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//private fun TransferConfirmationPreview() {
//    TransferPayment(rememberNavController())
//}
@Composable
fun TransferPaymentTopBar(navController: NavController,modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
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
                .padding(bottom = 8.dp,),
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

