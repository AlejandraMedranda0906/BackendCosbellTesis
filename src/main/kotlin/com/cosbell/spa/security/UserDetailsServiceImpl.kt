package com.cosbell.spa.security

import com.cosbell.spa.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(private val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val user: User = userRepository.findByEmail(request.email!!)
            ?: throw RuntimeException("User not found")

        return org.springframework.security.core.userdetails.User(
            user.email,
            user.password,
            listOf() // agregar roles/authorities
        )
    }
}
