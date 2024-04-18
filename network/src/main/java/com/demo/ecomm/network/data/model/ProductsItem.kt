package com.demo.ecomm.network.data.model

import com.demo.ecomm.data.model.Category

data class ProductsItem(
    val category: Category? = null,
    val description: String? = null,
    val id: Int = 0,
    val images: List<String> = listOf(),
    val price: Int = 0,
    val title: String = ""
)