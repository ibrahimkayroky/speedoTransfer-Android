package com.gradproj.SpeedoTransferApp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gradproj.SpeedoTransferApp.R
import com.gradproj.SpeedoTransferApp.features.navigation.Screen
import com.gradproj.SpeedoTransferApp.features.profile.Profile
import com.gradproj.SpeedoTransferApp.ui.theme.G10
import com.gradproj.SpeedoTransferApp.ui.theme.G100
import com.gradproj.SpeedoTransferApp.ui.theme.G200
import com.gradproj.SpeedoTransferApp.ui.theme.G40
import com.gradproj.SpeedoTransferApp.ui.theme.G70
import com.gradproj.SpeedoTransferApp.ui.theme.G700
import com.gradproj.SpeedoTransferApp.ui.theme.G900
import com.gradproj.SpeedoTransferApp.ui.theme.P300
import com.gradproj.SpeedoTransferApp.ui.theme.P50
import com.gradproj.SpeedoTransferApp.ui.theme.redGradient
import com.gradproj.SpeedoTransferApp.ui.theme.white
import com.gradproj.SpeedoTransferApp.ui.theme.yellowGradient

@Composable
fun GradientBackground(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(0.0f to white, 1.0f to redGradient)
            )
    ) {
        content()
    }
}

@Composable
fun GradientBackground2(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(0.0f to yellowGradient, 1.0f to redGradient)
            )
    ) {
        content()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    header: String,
    placeHolder: String,
    icon: ImageVector,
    inputType: KeyboardType,
    textState: MutableState<String>,
    errorState: MutableState<Boolean> = remember { mutableStateOf(false) },
    errorMessage: String = "Invalid input",
    onValueChange: (String) -> Unit = { newValue -> textState.value = newValue },
    modifier: Modifier = Modifier,
){

    var passwordVisible by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        Text(
            text = header,
            fontWeight = FontWeight(400),
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = textState.value,
            placeholder = { Text(text = placeHolder) },
            onValueChange = { newValue -> onValueChange(newValue) },
            keyboardOptions = KeyboardOptions(keyboardType = inputType),
            supportingText = {
                if (errorState.value) {
                    Text(errorMessage)
                }
            },
            isError = errorState.value,
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
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    buttonType: String,
    modifier: Modifier = Modifier
){

    var enabled by remember { mutableStateOf(true) }

    val buttonColor = if(buttonType == "Filled")
        ButtonDefaults.buttonColors(containerColor = P300)
    else
        ButtonDefaults.buttonColors(containerColor = Color.White)

    Button(
        onClick = { onClick() },
        colors =  if(enabled) buttonColor else ButtonDefaults.buttonColors(containerColor = G100),
        shape = RoundedCornerShape(6.dp),
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.5.dp,
                color = if (buttonType == "Outlined" && enabled) Color(P300.value) else Color.Transparent,
                shape = RoundedCornerShape(6.dp)
            )
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            color = if(buttonType == "Outlined" && enabled) P300 else Color.White
        )
    }
}

@Composable
fun ProfileComponent(
    navController: NavController,
    pageToGo: String,
    header: String,
    description: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
){
    Column(
        modifier = Modifier
            .clickable {
                navController.navigate(pageToGo)
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFFF3E9EB),
                modifier = Modifier
                .padding(end = 16.dp)
            ){
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = P300,
                    modifier = Modifier
                        .padding(12.dp)
                        .width(24.dp)
                        .height(24.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = header,
                    fontWeight = FontWeight.W500,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                )
                Text(
                    text = description,
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp,
                    color = G100
                )
            }

            Spacer(
                modifier = Modifier
                .weight(1f)
            )

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.chevron_rightic),
                contentDescription = null,
                tint = G200,
                modifier = Modifier
                    .padding(top = 12.dp)
            )
        }
        HorizontalDivider(thickness = 1.dp, color = G100)
    }
}

@Composable
fun ProfileInformationComponent(
    header: String,
    description: String
){
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = header,
            fontWeight = FontWeight.W500,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 16.dp,bottom = 16.dp)
        )
        Text(
            text = description,
            fontWeight = FontWeight.W400,
            fontSize = 16.sp,
            color = G100,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        HorizontalDivider(thickness = 1.dp, color = G100)
    }
}

@Composable
fun MoreMenuItem(
    itemDescription: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(vertical = 16.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = G200,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .width(24.dp)
                    .height(24.dp)
            )

            Text(
                text = itemDescription,
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                color = G200
            )

            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
            if(itemDescription != "Logout")
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.chevron_rightic),
                    contentDescription = null,
                    tint = G200,
                    modifier = Modifier
                )
        }
        if(itemDescription != "Logout")
            HorizontalDivider(thickness = 1.dp, color = G100)
    }
}

@Composable
fun FavouritesComponent(
    name: String,
    accountNO: String,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(P50),
        modifier = modifier
            .width(344.dp)
            .height(88.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.bank_card),
                contentDescription = "bank card icon",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(48.dp)
            )
            Column(
                modifier = Modifier
                    .padding(end = 55.dp)
            ){
                Text(
                    text = name,
                    fontWeight = FontWeight.W500,
                    fontSize = 16.sp,
                    color = G900,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = accountNO,
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp,
                    color = G100
                )
            }
            Image(
                painter = painterResource(id = R.drawable.editic),
                contentDescription = "",
                colorFilter = ColorFilter.tint(G100),
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .clickable {
                            onEditClick()
                        }
            )

            Image(
                painter = painterResource(id = R.drawable.deleteic),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color(0xFFD80027)),
                modifier = Modifier
                    .clickable {
                        onDeleteClick()
                    }
            )

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProfilePreview() {
    FavouritesComponent(name = "Asmaa Desouky", accountNO = "Account xxxx7890", onEditClick = {}, onDeleteClick = {})
}



