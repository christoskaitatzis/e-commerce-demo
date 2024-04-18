package com.demo.ecommerce.data.di

import com.demo.ecommerce.data.ProductsRepository
import com.demo.ecommerce.data.ProductsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
fun interface RepositoryModule {
    @Binds
    fun bindsProductsRepository(
        productsRepositoryImpl: ProductsRepositoryImpl
    ): ProductsRepository
}