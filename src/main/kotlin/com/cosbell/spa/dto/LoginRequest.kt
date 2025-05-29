package com.cosbell.spa.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull



data class LoginRequest(

@NotNull(message = "email is required") @NotBlank(message = "email cannot be blank")
val email: String? = null,

@NotNull(message = "password is required") @NotBlank(message = "password cannot be blank")
val password: String

)