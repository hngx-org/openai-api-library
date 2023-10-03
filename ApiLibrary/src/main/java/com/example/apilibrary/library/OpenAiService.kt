package com.example.apilibrary.library

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

internal interface OpenAiService {
    @POST("/api/chat/completions")
    suspend fun callOpenApi(@Body prompt : Prompt) : Response<Completion>
}