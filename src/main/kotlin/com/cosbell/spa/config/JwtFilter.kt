package com.cosbell.spa.config

/*import com.auth0.jwt.interfaces.DecodedJWT
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtFilter(private val jwtUtil: JwtUtil) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION)
        if (!authorizationHeader.isNullOrEmpty() && authorizationHeader.startsWith("Bearer ")) {
            val jwtToken = authorizationHeader.substring(7)

            try {
                val decodedJWT: DecodedJWT = jwtUtil.validateToken(jwtToken)
                val username: String = jwtUtil.extractUsername(decodedJWT)

                val authorities: Collection<GrantedAuthority> = emptyList()
                val authenticationToken = UsernamePasswordAuthenticationToken(username, null, authorities)

                val context = SecurityContextHolder.createEmptyContext()
                context.authentication = authenticationToken
                SecurityContextHolder.setContext(context)

            } catch (ex: Exception) {
                logger.warn("Token inválido o expirado: ${ex.message}")
            }
        }

        filterChain.doFilter(request, response)
    }
}*/
