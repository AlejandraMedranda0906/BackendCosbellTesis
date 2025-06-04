/*package com.cosbell.spa.service
import com.cosbell.spa.dto.AuthResponse
import com.cosbell.spa.dto.LoginRequest
import com.cosbell.spa.dto.RegisterRequest
import com.cosbell.spa.entity.Role
import com.cosbell.spa.entity.User
import com.cosbell.spa.repository.UserRepository
import com.cosbell.spa.security.JwtService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userService: UserService
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService,
    private val authenticationManager: AuthenticationManager

) {
    fun register(request: RegisterRequest): AuthResponse {
        val user = User(
            name = request.name,
            email = request.email ?: "",
            password = passwordEncoder.encode(request.password),
            role = Role.valueOf(request.role.uppercase())
        )
        userRepository.save(user)
        val token = jwtService.generateToken(user)
        return AuthResponse(token = token, role = user.role.name)
    }

}

fun login(request: LoginRequest): AuthResponse {
    authenticationManager.authenticate(
        UsernamePasswordAuthenticationToken(request.email, request.password)
    )

    val user: User = userRepository.findByEmail(request.email!!)
        ?: throw RuntimeException("User not found")

    val token = jwtService.generateToken(user)
    return AuthResponse(token = token, role = user.role.name)
}*/

package com.cosbell.spa.service

import com.cosbell.spa.dto.AuthResponse
import com.cosbell.spa.dto.LoginRequest
import com.cosbell.spa.dto.RegisterRequest
import com.cosbell.spa.entity.Role
import com.cosbell.spa.entity.User
import com.cosbell.spa.repository.UserRepository
import com.cosbell.spa.security.JwtService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService,
    private val authenticationManager: AuthenticationManager
) {
    fun register(request: RegisterRequest): AuthResponse {
        if (userRepository.existsByEmail(request.email)) {
            return AuthResponse(message = "El correo ya está registrado")
        }
        val user = User(
            name = request.name,
            email = request.email,
            password = passwordEncoder.encode(request.password),
            role = Role.valueOf(request.role.uppercase())
        )
        userRepository.save(user)
        val token = jwtService.generateToken(user)
        return AuthResponse(token = token, role = user.role.name, message = "Usuario registrado correctamente")
    }

    fun login(request: LoginRequest): AuthResponse {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(request.email, request.password)
        )
        val user = userRepository.findByEmail(request.email)
            ?: return AuthResponse(message = "Credenciales incorrectas")
        val token = jwtService.generateToken(user)
        return AuthResponse(token = token, role = user.role.name, message = "Login exitoso")
    }
}
