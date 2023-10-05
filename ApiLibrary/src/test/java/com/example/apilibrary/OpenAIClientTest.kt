package com.example.apilibrary

import com.example.apilibrary.library.OpenAiClient
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Test

// Run the test as proof to see that the implementation in this library to connect to the OpenAi Api works.
class OpenAIClientTest {

    private val openAiClient = OpenAiClient()
    private val cookie = "session=484c69c3-0a9e-427d-b338-c2217d77a3b0.3pRAOitPvhIM7tsN6ipYFCes0P8"

    @Test
    fun getUserChatResponseTest() = runTest {
        flow {

           val res =  openAiClient.getUserChatResponse(
                "what was my last question?",
                listOf("user: Hello!",
                    "AI: Hi! How can I help you today?",
                    "user: I'm looking for information on the latest trends in artificial intelligence.",
                    "AI: Sure, here are some of the latest trends in artificial intelligence"),
                cookie
            )
            emit(res)
        }.catch { it.printStackTrace() }
            .collectLatest {
                println(it)
            }
    }

    @Test
    fun getChatResponseTest() = runTest {
        flow {

            val res =  openAiClient.getChatResponse(
                "who owns the brand AlienWare",
                cookie
            )
            emit(res)
        }.catch { it.printStackTrace() }
            .collectLatest {
                println(it)
            }
    }
}