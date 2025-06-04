package com.cosbell.spa.security

import com.cosbell.spa.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByEmail(username)
            ?: throw UsernameNotFoundException("Usuario no encontrado con email: $username")

        return org.springframework.security.core.userdetails.User(
            user.email,
            user.password,
            listOf() // Aquí puedes agregar roles si los tienes
        )
    }
}