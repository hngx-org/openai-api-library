package com.example.apilibrary.library

import android.util.Log
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

private const val TAG = "OpenAiClient"

internal class OpenAiClient {

    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json{
                prettyPrint = true
                isLenient = true
            })
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.d(TAG, "Network Message, log: $message")
                }
            }
            level=LogLevel.ALL
        }

        install(HttpTimeout) {
            socketTimeoutMillis = 10_000
            requestTimeoutMillis = 10_000
            connectTimeoutMillis = 10_000
        }
    }

    suspend fun getUserChatResponse(userPrompt: String, userPromptChat : Array<String>, userId : String) : String {
        val response : HttpResponse = client.post("https://spitfire-interractions.onrender.com/api/chat/completions/") {
            header("Accept", "application/json")
            header("Content-Type", "application/json")
            header("Cookie", userId)
            setBody(PromptChat(history = userPromptChat, user_input = userPrompt))
        }
        return response.body()
    }

    suspend fun getChatResponse(userPrompt: String, userId : String) : String {
        val response : HttpResponse = client.post("https://spitfire-interractions.onrender.com/api/chat/") {
            header("Accept", "application/json")
            header("Content-Type", "application/json")
            header("Cookie", userId)
            setBody(Prompt(user_input = userPrompt))
        }
        return response.body()
    }
}
