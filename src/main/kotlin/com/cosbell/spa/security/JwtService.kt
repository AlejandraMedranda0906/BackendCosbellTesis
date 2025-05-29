// JwtService.kt
package com.cosbell.spa.security

import com.cosbell.spa.entity.User
import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service
import java.util.*
import javax.crypto.SecretKey

@Service
class JwtService {
    // Clave secreta segura generada como una clave HMAC
    private val secretKey: SecretKey = Keys.hmacShaKeyFor("mi_clave_secreta_segura_muy_larga_para_hmac512".toByteArray())

    fun generateToken(user: User): String {
        return Jwts.builder()
            .setSubject(user.email)
            .claim("role", user.role.name)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 24 horas
            .signWith(secretKey, SignatureAlgorithm.HS512)
            .compact()
    }
}
