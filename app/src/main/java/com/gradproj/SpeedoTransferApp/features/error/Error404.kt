package com.gradproj.SpeedoTransferApp.features.error

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
fun Error404(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.error404),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 161.dp, bottom = 50.dp)
        )

        Text(
            text = stringResource(R.string.server_error),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = stringResource(R.string.error404_message),
                    modifier = Modifier
                    .padding(bottom = 32.dp)
        )

        CustomButton(
            text = stringResource(R.string.call_us),
            onClick = { /*TODO*/ },
            buttonType = "Filled",
            modifier = Modifier
                .padding(bottom = 16.dp)
                .height(51.dp)
        )
        CustomButton(
            text = stringResource(R.string.message_us),
            onClick = { /*TODO*/ },
            buttonType = "Outlined",
            modifier = Modifier
                .padding(bottom = 16.dp)
                .height(51.dp)
        )
    }
}