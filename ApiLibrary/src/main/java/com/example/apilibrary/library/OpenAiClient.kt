package com.example.apilibrary.library

import com.example.apilibrary.exception.BadRequestsException
import com.example.apilibrary.exception.InternalServerErrorException
import com.example.apilibrary.exception.PayTooLongException
import com.example.apilibrary.exception.PaymentRequiredException
import com.example.apilibrary.exception.TooManyRequestException
import com.example.apilibrary.exception.UnprocessableEntityException
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

internal class OpenAiClient {

    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    println(message)
                }
            }
            level = LogLevel.ALL
        }

        install(HttpTimeout) {
            socketTimeoutMillis = 10_000
            requestTimeoutMillis = 10_000
            connectTimeoutMillis = 10_000
        }

        HttpResponseValidator {
            validateResponse {
                when (val v = it.status.value) {
                    400 -> throw BadRequestsException(
                        "Bad Request"
                    )

                    402 -> throw PaymentRequiredException(
                        "Subscription Required",
                        "You do not have enough credits"
                    )

                    429 -> throw TooManyRequestException(
                        "Too Many Requests",
                        "Rate limit exceeded. Please try again later."
                    )

                    500 -> throw InternalServerErrorException(
                        "Internal Server Error",
                        "It's not you, it's us. We encountered an internal server error."
                    )

                    413 -> throw PayTooLongException(
                        "Payload Too Long",
                        "The request body is too long"
                    )

                    422 -> throw UnprocessableEntityException(
                        "Unprocessable Entity",
                        "The server cannot process the request due to invalid data."
                    )
                    404 -> throw Exception("Not Found")
                    401 -> throw Exception("Unauthorized Request")
                }
            }
        }
    }

    suspend fun getUserChatResponse(userPrompt: String, userPromptChat : List<String>, cookie : String) : String {
        val response : HttpResponse = client.post("https://spitfire-interractions.onrender.com/api/chat/completions/") {
            header("Accept", "application/json")
            header("Content-Type", "application/json")
            header("Cookie", cookie)
            setBody(PromptChat(history = userPromptChat, user_input = userPrompt))
        }
        return response.body()
    }

    suspend fun getChatResponse(userPrompt: String, cookie : String) : String {
        val response : HttpResponse = client.post("https://spitfire-interractions.onrender.com/api/chat/") {
            header("Accept", "application/json")
            header("Content-Type", "application/json")
            header("Cookie", cookie)
            setBody(Prompt(user_input = userPrompt))
        }
        return response.body()
    }
}