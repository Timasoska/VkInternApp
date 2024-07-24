package com.example.vkapp.ui.viewmodel

import com.example.vkapp.data.model.ProductModel
import retrofit2.Response

sealed class ProductViewState {
    object Loading: ProductViewState()
    //data class Success(val products: Response<ProductModel>): ProductViewState()
    data class Success(val products: ProductModel): ProductViewState()
    data class Error(val message: String): ProductViewState()
}