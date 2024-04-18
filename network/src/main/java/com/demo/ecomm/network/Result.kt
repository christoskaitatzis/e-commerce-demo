package com.demo.ecomm.network

sealed class Result<TYPE>(
    val data: TYPE? = null,
    val message: String? = null
) {
    class Success<TYPE>(data: TYPE?) : Result<TYPE>(data)
    class Error<TYPE>(data: TYPE? = null, message: String?) : Result<TYPE>(data, message)
}

