package com.example.apilibrary.library

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


internal interface OpenAiService {
    @POST("/api/chat/completions")
    suspend fun callUserChatResponse(@Body promptChat : PromptChat) : Response<PromptChatCompletion>

    @POST("/api/chat")
    suspend fun callChatResponse(@Body prompt : Prompt) : Response<PromptCompletion>
}