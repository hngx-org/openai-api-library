package com.example.apilibrary.exception

data class PaymentRequiredException(
    val error: String,
    val errorMessage: String
) : Exception("")

data class InternalServerErrorException(
    val error: String,
    val errorMessage: String
) : Exception("")

data class TooManyRequestException(
    val error: String,
    val errorMessage: String
) : Exception("")

data class BadRequestsException(
    val error: String,
) : Exception("")

data class PayTooLongException(
    val error: String,
    val errorMessage: String
) : Exception("")

data class UnprocessableEntityException(
    val error: String,
    val errorMessage: String
) : Exception("")