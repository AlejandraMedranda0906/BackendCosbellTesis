package com.cosbell.spa.service
import com.cosbell.spa.dto.AuthResponse
import org.springframework.stereotype.Service
import com.cosbell.spa.dto.LoginRequest
import com.cosbell.spa.dto.RegisterRequest
import com.cosbell.spa.entity.Role
import com.cosbell.spa.entity.User
import com.cosbell.spa.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun register(request: RegisterRequest): User {
        if (userRepository.existsByEmail(request.email)) {
            throw Exception("El correo ya está registrado")
        }
        val user = User(
            name = request.name,
            email = request.email,
            password = passwordEncoder.encode(request.password),
            role = Role.valueOf(request.role.uppercase())

        )
        return userRepository.save(user)
    }

    fun login(request: LoginRequest): AuthResponse {
        val user = userRepository.findByEmail(request.email)
            ?: throw Exception("Credenciales incorrectas")
        if (!passwordEncoder.matches(request.password, user.password)) {
            throw Exception("Credenciales incorrectas")
        }
        // Aquí deberías generar un JWT real, pero para pruebas:
        return AuthResponse(
            message = "Login exitoso",
            email = user.email,
            token = "fake-jwt-token",
            role = user.role.name
        )
        }
    }



/*@Service
class

UserService(

    @Autowired
    //lateinit var userRepository: UserRepository
    private val userRepository: UserRepository,
    private var passwordEncoder: PasswordEncoder
) {

    fun list(loginDto: LoginRequest): User {
        val User = userRepository.findByEmail(loginDto.email!!)
            ?: throw Exception("Usuario no encontrado")

        if (user.locked == true) throw Exception("Usuario bloqueado")
        if (user.disabled == true) throw Exception("Usuario deshabilitado")

        if (!passwordEncoder.matches(loginDto.password, user.password)) {
            throw Exception("Contraseña incorrecta")
        }
        return user}
}*/






//esto toomar en cuenta crea un endpoint para servicos y visualizar disponibles
/*GetMapping("/api/servicios")
fun getServicios(): List<ServicioDto> {
    return servicioService.getAllServicios()
}*/





/* @Service
class UserService {
    private val userRepository: UserRepository,
    private var passwordEncoder: PasswordEncoder
    ) {

        fun list(): List<UserEntity> = userRepository.findAll()

        fun listById(id: Long?): UserEntity? = id?.let { userRepository.findById(it).orElse(null) }

        fun updatePassword(loginDto: LoginRequest): UserEntity {
            val user = userRepository.findByUsername(loginDto.username!!)
                ?: throw Exception("Usuario no encontrado")

            user.password = passwordEncoder.encode(loginDto.password)
            return userRepository.save(user)
        }

        @Transactional
        fun delete(id: Long?): SuccessResponse {
            try {
                id?.let {
                    if (!userRepository.existsById(it)) throw Exception("Id no existe")
                    userRepository.deleteById(it)
                } ?: throw Exception("Id es null")
                return SuccessResponse("success")
            } catch (e: DataIntegrityViolationException) {
                throw SQLException("Violación de integridad de datos")
            } catch (e: Exception) {
                throw SQLException(e.message)
            }
        }fun login(loginDto: LoginRequest): UserEntity {
            val user = userRepository.findByEmail(loginDto.email!!)
                ?: throw Exception("Usuario no encontrado")

            if (user.locked == true) throw Exception("njnj")
            if (user.disabled == true) throw Exception("kjknjnnm")

            if (!passwordEncoder.matches(loginDto.password, user.password)) {
                throw Exception("lmkmk")
            }
            return user}*/