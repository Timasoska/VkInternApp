    package com.example.vkapp.ui.screens

    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material3.Button
    import androidx.compose.material3.CircularProgressIndicator
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.getValue
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.unit.dp
    import com.example.vkapp.ui.Components.SuccessComponents
    import com.example.vkapp.ui.viewmodel.ProductViewIntent
    import com.example.vkapp.ui.viewmodel.ProductViewModel
    import com.example.vkapp.ui.viewmodel.ProductViewState

    @Composable
    fun HomePage(productViewModel: ProductViewModel){
        val state by productViewModel.state
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            /*Button(onClick = {
                productViewModel.processIntent(ProductViewIntent.LoadNextPage)
            }) {
                Text(text = "CLICK")
            }*/
            /*Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            )*/ Box(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            contentAlignment = Alignment.Center
            ){
                when (state) {
                    is ProductViewState.Loading -> CircularProgressIndicator()
                    is ProductViewState.Success -> {
                        val products = (state as ProductViewState.Success).products
                        SuccessComponents(products)
                    }

                    is ProductViewState.Error -> {
                        val message = (state as ProductViewState.Error).message
                        Text(text = "Error: $message")
                        /// Что-то дописать
                    }
                }
            }
            Button(onClick = {
                productViewModel.processIntent(ProductViewIntent.LoadNextPage)
            }) {
                Text(text = "CLICK")
            }
        }
    }