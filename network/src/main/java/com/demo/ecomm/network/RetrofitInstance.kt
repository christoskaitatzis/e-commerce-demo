package com.demo.ecomm.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//object RetrofitInstance {
//
//    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
//        level = HttpLoggingInterceptor.Level.BODY
//    }
//
//    private val httpClient: OkHttpClient =
//        OkHttpClient.Builder().addInterceptor(interceptor).build()
//
//    val api: ApiService = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
//        .baseUrl(ApiService.BASE_URL).client(httpClient).build().create(ApiService::class.java)
//}