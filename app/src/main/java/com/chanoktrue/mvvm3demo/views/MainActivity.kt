package com.chanoktrue.mvvm3demo.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chanoktrue.mvvm3demo.models.ProductModel
import com.chanoktrue.mvvm3demo.ui.theme.MVVM3DemoTheme
import com.chanoktrue.mvvm3demo.viewmodels.ProductViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val productVM: ProductViewModel by viewModels()

        setContent {
            MainView(productVM = productVM)
        }
    }
}


@Composable
fun MainView(productVM: ProductViewModel = viewModel()) {

    var product by remember {
        mutableStateOf("")
    }

    var productModel = ProductModel(product, 99)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        OutlinedTextField(
            value = product,
            onValueChange = { product = it }
        )


        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { productVM.add(productModel)}, modifier = Modifier.width(100.dp)) {
                Text(text = "Add")
            }


            Button(onClick = { productVM.remove(productModel) }, modifier = Modifier.width(100.dp)) {
                Text(text = "Remove")
            }
        }

        Surface(
            modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
            elevation = 8.dp,
            shape = RoundedCornerShape(CornerSize(4.dp))
        ) {
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)) {
                items(productVM.getAll()) { product ->
                    Text(text = product.name)
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainView()
}