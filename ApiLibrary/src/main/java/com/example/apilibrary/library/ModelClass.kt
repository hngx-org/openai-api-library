package com.example.apilibrary.library

import com.squareup.moshi.Json

internal data class Prompt(
    @Json(name = "history") val history : Array<String> = emptyArray(),
    @Json(name = "user_input") val user_input : String = ""
)

data class Completion(
    @Json(name = "message") val message : String = ""
)