package com.cosbell.spa.dto

data class AuthResponse(
    val message: String? = null,
    val email: String? = null,
    val token: String? = null,
    val role: String? = null
)