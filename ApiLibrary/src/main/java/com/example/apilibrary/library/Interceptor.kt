package com.example.apilibrary.library

import okhttp3.Interceptor
import okhttp3.Response

lateinit var USER_COOKIE : String

internal class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response =  chain.request()
            .newBuilder()
            .addHeader("Accept", "application/json")
            .addHeader("Content-Type", "application/json")
            .addHeader("Cookie", USER_COOKIE)
            .build()
        return chain.proceed(response)
    }
}