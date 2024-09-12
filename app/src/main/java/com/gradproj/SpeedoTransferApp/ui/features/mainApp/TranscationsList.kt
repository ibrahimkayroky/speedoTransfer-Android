package com.gradproj.SpeedoTransferApp.ui.features.mainApp

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.gradproj.SpeedoTransferApp.models.TransactionResponse
import com.gradproj.SpeedoTransferApp.ui.components.BottomBar
import com.gradproj.SpeedoTransferApp.ui.components.GradientBackground2
import com.gradproj.SpeedoTransferApp.ui.components.TransactionComponent
import com.gradproj.SpeedoTransferApp.ui.viewmodels.TransViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TransactionsList(
    navController: NavController,
    TransViewModel: TransViewModel,
    modifier: Modifier = Modifier
) {
    val transactions by TransViewModel.transactions.collectAsState()

    GradientBackground2 {
        Scaffold(
            bottomBar = { BottomBar(navController,"transaction") }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 16.dp)
            ) {
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
                        text = "Transactions",
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
                        text = "Your last transactions",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W600,
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                    )
                }
                TransactionList2(transactions)
            }
        }
    }
}
@Composable
fun TransactionList2(transactions: TransactionResponse?) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        if(transactions != null) {
            items(transactions) { transaction ->
                val amount = transaction.amount
                val receiverName = transaction.receiverName

                TransactionComponent(
                    amount = amount.toString(),
                    receiverName = receiverName
                )
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//private fun TransactionsListPreview() {
//    TransactionsList(navController = rememberNavController())
//}