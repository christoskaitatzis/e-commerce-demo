package com.demo.ecommerce.data.di

import com.demo.ecomm.network.ApiService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import com.demo.ecommerce.data.MyModelRepository
import com.demo.ecommerce.data.DefaultMyModelRepository
import com.demo.ecommerce.data.ProductsRepository
import com.demo.ecommerce.data.ProductsRepositoryImpl
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindsMyModelRepository(
        myModelRepository: DefaultMyModelRepository
    ): MyModelRepository
}

class FakeMyModelRepository @Inject constructor() : MyModelRepository {
    val fakeMyModels = listOf("One", "Two", "Three")
    override val myModels: Flow<List<String>> = flowOf(fakeMyModels)

    override suspend fun add(name: String) {
        throw NotImplementedError()
    }
}


