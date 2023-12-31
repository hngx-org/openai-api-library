package com.example.apilibrary.library

import kotlinx.serialization.Serializable

@Serializable
internal data class PromptChat(
    val history : List<String>,
    val user_input : String
)

@Serializable
internal data class Prompt(
    val user_input : String
)