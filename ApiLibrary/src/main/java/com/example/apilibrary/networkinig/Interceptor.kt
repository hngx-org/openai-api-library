package com.example.apilibrary.networkinig

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response =  chain.request()
            .newBuilder()
            .addHeader( "Accept", "application/json")
            .build()
        return chain.proceed(response)
    }
}