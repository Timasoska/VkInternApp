package com.example.vkapp.ui.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.vkapp.data.model.Product
import com.example.vkapp.data.model.ProductModel
import com.example.vkapp.ui.viewmodel.ProductViewModel

@Composable
fun SuccessComponents(products: ProductModel) {
    Column(){
        for (product in products.products){
            Text(text = "Title: ${product.title}")
            Text(text = "Description: ${product.description}")
            Text(text = "Thumbnail: ${product.thumbnail}")
        }
    }
}