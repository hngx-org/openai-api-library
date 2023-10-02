package com.example.apilibrary.api

import com.example.apilibrary.models.Completion
import com.example.apilibrary.models.Prompt
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface OpenAiService {

    @POST("/api/chat/completions")
    suspend fun callOpenApi(@Body prompt : Prompt) : Response<Completion>

}