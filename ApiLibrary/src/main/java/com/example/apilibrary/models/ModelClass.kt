package com.example.apilibrary.models

import com.squareup.moshi.Json

data class Prompt(
    @Json(name = "user_input") val user_input : String = ""
)

data class Completion(
    @Json(name = "message") val message : String = ""
)