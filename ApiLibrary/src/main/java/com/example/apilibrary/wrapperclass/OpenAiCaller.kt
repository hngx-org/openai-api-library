package com.example.apilibrary.wrapperclass

import com.example.apilibrary.library.Completion
import com.example.apilibrary.library.Prompt
import com.example.apilibrary.library.OpenAiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class OpenAiCaller {
    companion object {
        suspend fun generateResponse(userInput: String, savedHistory : Array<String> = arrayOf()): Response<Completion> {
            val openAiClient = OpenAiClient.service
            return withContext(Dispatchers.IO) {
                val response = openAiClient.callOpenApi(Prompt(user_input = userInput, history = savedHistory))
                return@withContext response
            }
        }
    }
}