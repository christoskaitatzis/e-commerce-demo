package com.demo.ecommerce.data

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.demo.ecomm.network.ApiService
import com.demo.ecomm.network.Result
import com.demo.ecomm.network.data.model.Products

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

fun interface ProductsRepository {
    suspend fun getProducts(): Flow<Result<Products>>
}

class ProductsRepositoryImpl @Inject constructor(
    private val apiService : ApiService
): ProductsRepository {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getProducts(): Flow<Result<Products>> {
        return flow {
            val productsFromApi = try {
                apiService.getProducts()
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