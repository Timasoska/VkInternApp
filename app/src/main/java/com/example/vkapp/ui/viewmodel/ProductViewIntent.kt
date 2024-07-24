package com.example.vkapp.ui.viewmodel

sealed class ProductViewIntent {
    object LoadNextPage : ProductViewIntent()

}