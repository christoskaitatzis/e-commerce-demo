package com.demo.ecommerce.data.local

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.demo.ecomm.network.ApiServices
import com.demo.ecomm.network.Result
import com.demo.ecomm.network.data.model.Products

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

fun interface ProductsRepository {
    suspend fun getProducts(): Flow<Result<Products>>
}

class ProductsRepositoryImpl(
    private val apiServices : ApiServices
): ProductsRepository {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getProducts(): Flow<Result<Products>> {
        return flow {
            val productsFromApi = try {
                apiServices.getProducts()
            } catch (exception: IOException) {
                exception.printStackTrace()
                emit(Result.Error(message = "error loading products"))
                return@flow
            } catch (exception: HttpException) {
                exception.printStackTrace()
                emit(Result.Error(message = "error loading products"))
                return@flow
            } catch (exception: Exception) {
                exception.printStackTrace()
                emit(Result.Error(message = "error loading products"))
                return@flow
            }

            emit (Result.Success(productsFromApi))
        }
    }
}