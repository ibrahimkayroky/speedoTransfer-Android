package com.gradproj.SpeedoTransferApp.ui.features.error

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gradproj.SpeedoTransferApp.R
import com.gradproj.SpeedoTransferApp.ui.components.CustomButton

@Composable
fun NoInternet(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.no_internet),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 189.dp, bottom = 53.dp)
        )

        Text(
            text = ("Internet connection"),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = " disabled...",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 32.dp)
        )

        CustomButton(
            text = "Update",
            onClick = { /*TODO*/ },
            buttonType = "Filled",
            modifier = Modifier
                .height(51.dp)
        )
    }
}