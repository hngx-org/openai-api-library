package com.example.apilibrary.wrapperclass

import com.example.apilibrary.models.Completion
import com.example.apilibrary.models.Prompt
import com.example.apilibrary.networkinig.OpenAiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class OpenAiCaller {
    companion object {
        suspend fun generateResponse(userInput: String): Response<Completion> {
            val openAiClient = OpenAiClient.service
            val response = openAiClient.callOpenApi(Prompt(user_input = userInput))
            return response
        }
    }
}