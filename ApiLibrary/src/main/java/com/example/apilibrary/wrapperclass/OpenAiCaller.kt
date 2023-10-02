package com.example.apilibrary.wrapperclass

import com.example.apilibrary.models.Completion
import com.example.apilibrary.models.Prompt
import com.example.apilibrary.networkinig.OpenAiClient
import retrofit2.Response

class OpenAiCaller {
    companion object {
        suspend fun generateResponse(userInput: String): Response<Completion> {
            val openAiClient = OpenAiClient.service
            return openAiClient.callOpenApi(Prompt(user_input = userInput))
        }
    }
}