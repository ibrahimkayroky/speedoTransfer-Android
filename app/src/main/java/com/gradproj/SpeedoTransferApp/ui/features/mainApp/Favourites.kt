package com.gradproj.SpeedoTransferApp.ui.features.mainApp

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
import com.gradproj.SpeedoTransferApp.ui.components.FavouritesComponent

@Composable
fun Favourites(navController: NavController, modifier: Modifier = Modifier) {

    val showBottomSheet = true

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 16.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
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
                text = "Favourites",
                fontWeight = FontWeight.W500,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(end = 36.dp)
            )

            Spacer(modifier = Modifier.weight(1f))
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Your favourites list",
                fontSize = 20.sp,
                fontWeight = FontWeight.W600,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )

            FavouritesComponent(
                name = "Asmaa Desouky",
                accountNO = "Account xxxx7890",
                showBottomSheet,
                {},
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )

            FavouritesComponent(
                name = "Asmaa Desouky",
                accountNO = "Account xxxx7890",
                showBottomSheet,
                {},
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun FavouritesPreview() {
    Favourites(navController = rememberNavController())
}