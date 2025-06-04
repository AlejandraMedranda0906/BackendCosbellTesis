/*package com.cosbell.spa.controller

import com.cosbell.spa.dto.LoginRequest
import com.cosbell.spa.dto.RegisterRequest
import com.cosbell.spa.response.SuccessResponse
import com.cosbell.spa.service.AuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
@RestController
@RequestMapping("/auth")
 class RequestController @Autowired constructor(
    private val authService: AuthService
) {
    @PostMapping("/register")
    fun register(@RequestBody dto: RegisterRequest): ResponseEntity<SuccessResponse> {
        return ResponseEntity.ok(authService.register(dto))
    }*/

    /*@PostMapping("/login")
    fun login(@RequestBody dto: LoginRequest): ResponseEntity<SuccessResponse> {
        return ResponseEntity.ok(authService.login(dto))
    }} */