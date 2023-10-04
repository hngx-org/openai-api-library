package com.example.apilibrary.wrapperclass

import com.example.apilibrary.library.OpenAiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OpenAiCaller {
    companion object {
        suspend fun generateUserChatResponse(userPrompt: String, userPromptChat: Array<String>, userId: String) : String {
            val openAiClient = OpenAiClient()
            return withContext(Dispatchers.IO) {
                return@withContext openAiClient.getUserChatResponse(
                    userPrompt,
                    userPromptChat,
                    userId
                )
            }
        }
        suspend fun generateChatResponse(userPrompt: String, userId: String) : String {
            val openAiClient = OpenAiClient()
            return withContext(Dispatchers.IO) {
                return@withContext openAiClient.getChatResponse(userPrompt, userId)
            }
        }
    }
}