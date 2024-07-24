package com.example.vkapp.ui.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.vkapp.data.model.Product
import com.example.vkapp.data.model.ProductModel
import com.example.vkapp.ui.viewmodel.ProductViewModel

@Composable
fun SuccessComponents(products: ProductModel) {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        itemsIndexed(products.products){_, item ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
            ) {
                AsyncImage(
                    model = item.thumbnail,
                    contentDescription = "ImageProducts",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(90.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp)) // Space between image and text
                Column(
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text(
                        text = item.title,
                        fontSize = 30.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = item.description,
                        fontSize = 20.sp,
                        color = Color.Gray,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
        }
    }
}