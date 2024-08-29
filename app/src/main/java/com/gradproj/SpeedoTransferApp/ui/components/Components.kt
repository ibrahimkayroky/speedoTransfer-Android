package com.gradproj.SpeedoTransferApp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gradproj.SpeedoTransferApp.R
import com.gradproj.SpeedoTransferApp.ui.theme.G70
import com.gradproj.SpeedoTransferApp.ui.theme.G700
import com.gradproj.SpeedoTransferApp.ui.theme.P300
import com.gradproj.SpeedoTransferApp.ui.theme.P75
import com.gradproj.SpeedoTransferApp.ui.theme.white

@Composable
fun GradientBackground(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(0.0f to white, 1.0f to Color(0xFFFFE6F0))
            )
    ) {
        content()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun customTextField(
    header: String, placeHolder: String, icon: ImageVector, inputType: KeyboardType, modifier: Modifier = Modifier
){

    var text by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        Text(
            text = header,
            fontWeight = FontWeight(400),
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = text,
            placeholder = { Text(text = placeHolder) },
            onValueChange = {text = it},
            keyboardOptions = KeyboardOptions(keyboardType = inputType),
            visualTransformation = if (!passwordVisible && inputType == KeyboardType.Password) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = {
                if(inputType == KeyboardType.Password){
                    val image = if (passwordVisible)
                        ImageVector.vectorResource(id = R.drawable.eye_compic)
                    else ImageVector.vectorResource(id = R.drawable.eye_compic_1)

                    IconButton(onClick = {passwordVisible = !passwordVisible}) {
                        Icon(
                            imageVector = image,
                            contentDescription = null
                        )
                    }
                }
                else{
                    Icon(
                        imageVector = icon,
                        contentDescription = null
                    )
                }
            },
            shape = RoundedCornerShape(6.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = G700,
                unfocusedBorderColor = G70,
                focusedTextColor = G700,
                unfocusedTextColor = G700,
                focusedTrailingIconColor = G700,
                unfocusedTrailingIconColor = G70
            ),
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Composable
fun customButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier){
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(containerColor = P300),
        shape = RoundedCornerShape(6.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(text = text, fontSize = 16.sp)
    }
}

