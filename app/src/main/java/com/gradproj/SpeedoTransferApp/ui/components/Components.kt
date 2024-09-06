package com.gradproj.SpeedoTransferApp.ui.components

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gradproj.SpeedoTransferApp.R
import com.gradproj.SpeedoTransferApp.features.navigation.Screen
import com.gradproj.SpeedoTransferApp.ui.theme.G0
import com.gradproj.SpeedoTransferApp.ui.theme.G100
import com.gradproj.SpeedoTransferApp.ui.theme.G200
import com.gradproj.SpeedoTransferApp.ui.theme.G70
import com.gradproj.SpeedoTransferApp.ui.theme.G700
import com.gradproj.SpeedoTransferApp.ui.theme.P300
import com.gradproj.SpeedoTransferApp.ui.theme.redGradient
import com.gradproj.SpeedoTransferApp.ui.theme.white
import com.gradproj.SpeedoTransferApp.ui.theme.yellowGradient
import java.util.Locale

enum class ExtraType
{
    country,date,none
}

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
    header: String, placeHolder: String, icon: ImageVector, inputType: KeyboardType, textState: MutableState<String>,extratype: ExtraType=ExtraType.none,  modifier: Modifier = Modifier
){
    val isoCountryCodes: Array<String> = Locale.getISOCountries()


    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    var text by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var sheetExpanded by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->

            textState.value = "$dayOfMonth/${month + 1}/$year"
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )


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
            onValueChange = {textState.value = it},
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
                else if (extratype == ExtraType.date) {
                    IconButton(onClick = { datePickerDialog.show() }) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null
                        )
                    }
                } else if (extratype == ExtraType.country) {

                    IconButton(onClick = { sheetExpanded = !sheetExpanded }) {
                        Icon(
                            imageVector = icon,
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
    if(sheetExpanded){
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { sheetExpanded = false}
        ){
            LazyColumn(){
                items(isoCountryCodes){ isoCode ->
                    val flagEmoji = getFlagEmoji(isoCode)
                    val countryName = Locale("", isoCode).displayCountry
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {   textState.value = countryName
                            sheetExpanded=false}  ) {

                        Text(text = flagEmoji, modifier = Modifier.padding(16.dp))


                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = countryName, modifier = Modifier.padding(16.dp))
                    }
                }
            }

        }
    }


}
fun getFlagEmoji(countryCode: String): String {
    val uppercaseCountryCode = countryCode.uppercase()

    // Check if the country code has exactly 2 characters
    if (uppercaseCountryCode.length != 2) {
        return "" // Return an empty string if the country code is invalid
    }

    // Calculate the Unicode code points for the regional indicator symbols
    val firstChar = Character.codePointAt(uppercaseCountryCode, 0) - 0x41 + 0x1F1E6
    val secondChar = Character.codePointAt(uppercaseCountryCode, 1) - 0x41 + 0x1F1E6

    // Return the flag emoji by combining the two regional indicator symbols
    return String(Character.toChars(firstChar)) + String(Character.toChars(secondChar))
}



@Composable
fun CustomButton(text: String, onClick: () -> Unit, buttonType: String, modifier: Modifier = Modifier){

    var enabled by remember { mutableStateOf(true) }

    val buttonColor = if(buttonType == "Filled")
        ButtonDefaults.buttonColors(containerColor = P300, contentColor = G0)
    else
        ButtonDefaults.buttonColors(containerColor = Color.Transparent, contentColor = P300)


    Button(
        onClick = { onClick() },
        colors =  if(enabled) buttonColor else ButtonDefaults.buttonColors(containerColor = G100),
        shape = RoundedCornerShape(6.dp),
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.5.dp,
                color = if(buttonType == "Outlined" && enabled) Color(P300.value) else Color.Transparent,
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
fun BottomBar(navController: NavController, Type:String) {
    Surface(  color = Color.White,
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp), // Adjust curve here
        shadowElevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable {
                    navController.navigate(Screen.Home.route) }) {
                if(Type=="home"){
                    Icon(painter = painterResource(id = R.drawable.homeic), contentDescription = "home",tint = P300)
                    Text(text = "Home",color = P300)
                }else{
                    Icon(painter = painterResource(id = R.drawable.homeic), contentDescription = "home",tint = G200)
                    Text(text = "Home",color = G200)
                }

            }
            Column (verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.clickable {
                    navController.navigate(Screen.TransferAmount.route) }) {
                if(Type=="transfer"){
                    Icon(painter = painterResource(id = R.drawable.transfer_1ic), contentDescription = "home",tint = P300)
                    Text(text = "Transfer",color = P300)
                }else{
                    Icon(painter = painterResource(id = R.drawable.transfer_1ic), contentDescription = "Transfer",tint = G200)
                    Text(text = "Transfer",color = G200)
                }
            }
            Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)  {
                if(Type=="transaction"){
                    Icon(painter = painterResource(id = R.drawable.history_1ic), contentDescription = "Transaction",tint = P300)
                    Text(text = "Transaction",color = P300)
                }else{
                    Icon(painter = painterResource(id = R.drawable.history_1ic), contentDescription = "Transaction", tint = G200)
                    Text(text = "Transaction",color = G200)
                }
            }
            Column (verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                if(Type=="card"){
                    Icon(painter = painterResource(id = R.drawable.cards_1ic), contentDescription = "My Card",tint = P300)
                    Text(text = "My Card",color = P300)
                }else{
                    Icon(painter = painterResource(id = R.drawable.cards_1ic), contentDescription = "My Card", tint = G200)
                    Text(text = "My Card",color = G200)
                }
            }
            Column (verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                if(Type=="more"){
                    Icon(painter = painterResource(id = R.drawable.moreic), contentDescription = "more",tint = P300)
                    Text(text = "More",color = P300)
                }else{
                    Icon(painter = painterResource(id = R.drawable.moreic), contentDescription = "more", tint = G200)
                    Text(text = "More",color = G200)
                }
            }
        }
    }
}


