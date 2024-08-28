package com.gradproj.SpeedoTransferApp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gradproj.SpeedoTransferApp.R
import com.gradproj.SpeedoTransferApp.ui.theme.P100
import com.gradproj.SpeedoTransferApp.ui.theme.P200
import com.gradproj.SpeedoTransferApp.ui.theme.P50
import com.gradproj.SpeedoTransferApp.ui.theme.P500
import com.gradproj.SpeedoTransferApp.ui.theme.P75
import com.gradproj.SpeedoTransferApp.ui.theme.white

@Composable
fun GradientBackground(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(0.0f to white, 1.0f to P75)
            )
    ) {
        content()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun customTextField(
    header: String, placeHolder: String, icon: ImageVector
){

    var text by remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }

    Column() {
        Text(text = header,
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = text,
            placeholder = { Text(text = placeHolder)},
            onValueChange = {text = it},
            trailingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = if (isFocused) Color.Blue else Color.Gray) },
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.fillMaxWidth()
                .onFocusChanged { focusState ->
                isFocused = focusState.isFocused
            }
        )
    }

}

