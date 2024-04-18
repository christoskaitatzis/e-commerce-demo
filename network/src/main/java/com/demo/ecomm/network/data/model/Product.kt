package com.demo.ecomm.network.data.model

import com.demo.ecomm.data.model.Category

data class Product(
    val category: Category,
    val description: String,
    val id: Int,
    val images: List<String>,
    val price: Int,
    val title: String
)