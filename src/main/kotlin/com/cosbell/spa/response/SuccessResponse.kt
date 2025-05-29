package com.cosbell.spa.response

data class SuccessResponse(
    val message: String,
    val token: String? = null,
    val role: String? = null
)