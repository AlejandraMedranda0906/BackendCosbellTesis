package com.cosbell.spa.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class LoginRequest(
    @field:NotBlank(message = "El correo es obligatorio")
    @field:Email(message = "El correo no es válido")
    val email: String,

    @field:NotBlank(message = "La contraseña es obligatoria")
    val password: String
)