package com.example.apilibrary.wrapperclass

import com.example.apilibrary.library.PromptChat
import com.example.apilibrary.library.OpenAiClient
import com.example.apilibrary.library.Prompt
import com.example.apilibrary.library.PromptChatCompletion
import com.example.apilibrary.library.PromptCompletion
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class OpenAiCaller {
    companion object {
        suspend fun generateUserChatResponse(userInput: String, savedHistory : Array<String>): Response<PromptChatCompletion> {
            val openAiClient = OpenAiClient.service
            return withContext(Dispatchers.IO) {
                val response = openAiClient.callUserChatResponse(PromptChat(user_input = userInput, history = savedHistory))
                return@withContext response
            }
        }

        suspend fun generateChatResponse(userInput: String): Response<PromptCompletion> {
            val openAiClient = OpenAiClient.service
            return withContext(Dispatchers.IO) {
                val response = openAiClient.callChatResponse(Prompt(user_input = userInput))
                return@withContext response
            }
        }
    }
}