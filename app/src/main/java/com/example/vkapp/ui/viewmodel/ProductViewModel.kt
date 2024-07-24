package com.example.vkapp.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkapp.data.network.ProductApi
import com.example.vkapp.data.network.RetrofitInstance
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val _state = mutableStateOf<ProductViewState>(ProductViewState.Loading)
    val state: State<ProductViewState> = _state
    val productApi = RetrofitInstance.productApi
    private var currentLimit = 0
    private var currentSkip = 0

    init {
        // Загрузка данных при инициализации ViewModel
        loadNextPage()
    }

    fun processIntent(intent: ProductViewIntent){
        when(intent){
            is ProductViewIntent.LoadNextPage -> loadNextPage()
        }
    }

    private fun loadNextPage(){
        viewModelScope.launch{
            _state.value = ProductViewState.Loading
            try{
                currentSkip+=10
                currentLimit+=10
                val response = productApi.getProducts(currentLimit,currentLimit)
                _state.value = ProductViewState.Success(response.body()!!)
                Log.i("Response",state.value.toString() )
            } catch (e: Exception){
                _state.value = ProductViewState.Error("Error")
            }
        }
    }

}