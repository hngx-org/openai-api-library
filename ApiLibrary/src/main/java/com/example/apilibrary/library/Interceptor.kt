package com.example.apilibrary.library

import okhttp3.Interceptor
import okhttp3.Response

internal class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response =  chain.request()
            .newBuilder()
            .addHeader( "Accept", "application/json")
            .addHeader("Authorization", "")
            .build()
        return chain.proceed(response)
    }
}