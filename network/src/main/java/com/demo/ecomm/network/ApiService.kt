package com.demo.ecomm.network

import com.demo.ecomm.network.data.model.Products
import retrofit2.http.GET

fun interface ApiService {

    @GET("/api/v1/products")
    suspend fun getProducts(): Products

    companion object {
        const val BASE_URL = "https://api.escuelajs.co/"
    }
}