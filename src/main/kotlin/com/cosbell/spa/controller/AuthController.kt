/*package com.cosbell.spa.controller
import com.cosbell.spa.dto.AuthResponse
import com.cosbell.spa.dto.LoginRequest
import com.cosbell.spa.dto.RegisterRequest
import com.cosbell.spa.service.AuthService
import com.cosbell.spa.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authService: AuthService,
    private val userService: UserService
) {

    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): ResponseEntity<AuthResponse> {
        val user = userService.register(request)
        return ResponseEntity.ok(AuthResponse("Usuario registrado correctamente", user.email))
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<AuthResponse> {
        return try {
            val response = authService.login(request)
            ResponseEntity.ok(response)
        } catch (e: Exception) {
            ResponseEntity.badRequest().body(AuthResponse(e.message ?: "Error desconocido"))
        }
    }
}*/

package com.cosbell.spa.controller

import com.cosbell.spa.dto.AuthResponse
import com.cosbell.spa.dto.LoginRequest
import com.cosbell.spa.dto.RegisterRequest
import com.cosbell.spa.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authService: AuthService
) {
    @PostMapping("/register")
    fun register(@RequestBody request: RegisterRequest): ResponseEntity<AuthResponse> =
        ResponseEntity.ok(authService.register(request))

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<AuthResponse> =
        ResponseEntity.ok(authService.login(request))
}




