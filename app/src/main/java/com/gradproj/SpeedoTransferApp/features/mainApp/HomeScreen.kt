package com.gradproj.SpeedoTransferApp.features.mainApp


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gradproj.SpeedoTransferApp.R
import com.gradproj.SpeedoTransferApp.ui.components.BottonBar
import com.gradproj.SpeedoTransferApp.ui.components.GradientBackground2
import com.gradproj.SpeedoTransferApp.ui.theme.G0
import com.gradproj.SpeedoTransferApp.ui.theme.G200
import com.gradproj.SpeedoTransferApp.ui.theme.G40
import com.gradproj.SpeedoTransferApp.ui.theme.G700
import com.gradproj.SpeedoTransferApp.ui.theme.G900
import com.gradproj.SpeedoTransferApp.ui.theme.P300

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    GradientBackground2 {
        Scaffold(
            bottomBar = { BottonBar("home") },
            topBar={
                TopBar()
            }
        ) { paddingValues ->
            val balance=10000
            Column( modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) ) {
                Card(
                    shape = CardDefaults.elevatedShape,
                    colors = CardDefaults.cardColors(P300),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .height(150.dp)
                ) {
                    Column( modifier =  Modifier

                        .padding(start = 16.dp) ,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start) {
                        Text(text = "Current Balance", color = G0, fontSize = 24.sp,modifier=modifier.padding(bottom = 16.dp,top = 16.dp))
                        Text(text = "$balance EGP",color = G0, fontSize = 34.sp,fontWeight = FontWeight.Bold)
                    }

                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                       Text(text="Recent transactions",color=G900)
                    Text(text = "View all", color = G200)
                }
                //lazy colmn will be added here later
            }

        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomeScreenPreview() {
    TransactionListItem("karen Samuel",12345678,500,"today","11:00","recieved")
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        // Api will change it 
        val name = "karen"
        val pic = R.drawable.error_ic
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, // Distributes space between elements
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp) // Adds padding around the row
        ) {
            // Profile Picture
            Box(
                contentAlignment = Alignment.Center, // Center the text inside the circle
                modifier = Modifier
                    .size(50.dp) // Circle size
                    .clip(CircleShape) // Clip to circle shape
                    .background(Color.Gray) // Background color of the circle
            ) {
                Text(
                    text = "ad",
                    fontSize = 20.sp, // Adjust text size as needed
                    fontWeight = FontWeight.Bold,
                    color = Color.White // Text color
                )
            }

            // Column with Welcome and Name
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f) // Allow the column to take the remaining space
            ) {
                Text(
                    text = "Welcome back,",
                    modifier = Modifier.padding(bottom = 4.dp),
                    color = P300
                )
                Text(text = name)
            }

            // Notification Icon
            Icon(
                painter = painterResource(id = R.drawable.notificationsic),
                contentDescription = "Notification Icon",
                modifier = Modifier.size(32.dp) // Set a fixed size for the icon
            )
        }

    }
}

@Composable
fun TransactionListItem(name :String ,cardNumber:Int,amount:Int,Day:String,Time:String,state:String,modifier: Modifier = Modifier) {
    Row (
        modifier
            .fillMaxWidth()
            .background(color = G40)
            .padding(8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.visa),
            contentDescription = "visa",
            contentScale = ContentScale.Fit,
            modifier = modifier
                .height(60.dp)
                .width(60.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier) {
            Text(text = name, color = G900)
            Text(text = "ViVisa . Mater Card . $cardNumber", color = G700)
            Text(text = "$Day $Time - $state", color = G700)

        }
        Text(text = "$amount EGP", color = P300, modifier = Modifier
            .weight(1f)
            .wrapContentWidth(Alignment.End) )
    }
}