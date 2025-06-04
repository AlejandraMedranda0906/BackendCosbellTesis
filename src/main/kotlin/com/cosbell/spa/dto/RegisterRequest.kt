/*package com.cosbell.spa.dto
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull


data class RegisterRequest(

    @NotNull(message = "fullname is required")
    @NotBlank(message = "fullname cannot be blank")
    val name: String,

    @NotNull(message = "email is required")
    @NotBlank(message = "email cannot be blank")
    val email: String? = null,

    @NotNull(message = "password is required")
    @NotBlank(message = "password cannot be blank")
    val password: String,

    val role: String ="CLIENT"
)*/

package com.cosbell.spa.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class RegisterRequest(
    @field:NotBlank(message = "El nombre es obligatorio")
    val name: String,

    @field:NotBlank(message = "El correo es obligatorio")
    @field:Email(message = "El cor reo no es válido")
    val email: String,

    @field:NotBlank(message = "La contraseña es obligatoria")
    val password: String,

    @field:NotBlank(message = "El rol es obligatorio")
    val role: String  //"ADMIN", "CLIENT" o "EMPLOYEE"
)

