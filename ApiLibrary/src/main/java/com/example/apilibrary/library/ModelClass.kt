package com.example.apilibrary.library

import com.squareup.moshi.Json

internal data class PromptChat(
    @Json(name = "history") val history : Array<String>,
    @Json(name = "user_input") val user_input : String
)

internal data class Prompt(
    @Json(name = "user_input") val user_input : String
)

data class PromptChatCompletion(
    @Json(name = "message") val message : String
)

data class PromptCompletion(
    @Json(name = "message") val message : String
)

