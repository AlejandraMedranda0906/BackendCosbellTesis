package com.cosbell.spa.controller

import com.cosbell.spa.entity.User
import com.cosbell.spa.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @PostMapping
    fun createUser(@RequestBody request: CreateUserRequest): User {
        return userService.createUser(request.name, request.email, request.password, request.roleId)
    }

    data class CreateUserRequest(
        val name: String,
        val email: String,
        val password: String,
        val roleId: Long
    )
}