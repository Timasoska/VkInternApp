package com.example.vkapp.data.network

import com.example.vkapp.data.model.ProductModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {

    @GET("products?limit=20&skip=10&select=title,description,thumbnail")//skip отвечает за количество пропущенных продуктов
    suspend fun getProducts(
        //@Query("") products : String,
    ) : Response<ProductModel>
}