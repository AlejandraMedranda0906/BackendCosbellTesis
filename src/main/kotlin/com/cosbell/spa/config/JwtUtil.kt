package com.cosbell.spa.config

import com.auth0.jwt.JWT
/*import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import org.springframework.stereotype.Component

@Component
class JwtUtil {

    private val secretKey = "tu_clave_secreta_segura"

    fun generateToken(email: String): String {
        val algorithm = Algorithm.HMAC256(secretKey)
        return JWT.create()
            .withSubject(email)
            .sign(algorithm)
    }

    fun validateToken(token: String): DecodedJWT {
        val algorithm = Algorithm.HMAC256(secretKey)
        val verifier = JWT.require(algorithm).build()
        return verifier.verify(token)
    }

    fun extractUsername(decodedJWT: DecodedJWT): String {
        return decodedJWT.subject
    }
}*/
