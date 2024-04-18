package com.demo.ecomm.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpClient: OkHttpClient =
        OkHttpClient.Builder().addInterceptor(interceptor).build()

    val api: ApiServices = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
        .baseUrl(ApiServices.BASE_URL).client(httpClient).build().create(ApiServices::class.java)
}