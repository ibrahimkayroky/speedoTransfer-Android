import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gradproj.SpeedoTransferApp.R
import com.gradproj.SpeedoTransferApp.models.Product
import com.gradproj.SpeedoTransferApp.navigation.Screen

import com.gradproj.SpeedoTransferApp.ui.components.CustomButton
import com.gradproj.SpeedoTransferApp.ui.components.CustomTextField
import com.gradproj.SpeedoTransferApp.ui.components.GradientBackground
import com.gradproj.SpeedoTransferApp.ui.theme.G100
import com.gradproj.SpeedoTransferApp.ui.theme.P300
import com.gradproj.SpeedoTransferApp.ui.viewmodels.ProductViewModel

@Composable
fun SignIn(navController: NavController, modifier: Modifier = Modifier,viewModel: ProductViewModel= viewModel()) {
    val products by viewModel.products.collectAsState()
    Log.d("trace", "Received categories: $products")
    Column(
        modifier = modifier.padding(top = 32.dp)
    ) {
        LazyColumn{
            items(products) { product ->
                MainproductListItem(product = product)
            }
        }

    }
}

@Composable
fun MainproductListItem(product: Product) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(end = 8.dp)
           ){
        Text(text = product.br ?: "Unknown Brand")

    }

}



