package com.cosbell.spa.entity

import jakarta.persistence.*
import java.security.Permission

//@Entity


enum class Role {
    CLIENT, EMPLOYEE, ADMIN
}

  /*  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val role: String = "",

    @Column(nullable = false)
    val email: String = "",

    @Column(nullable = false)
    val password: String = "",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "role_permission",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "permission_id")]
    )
    val permissions: List<Permission> = emptyList()
) {
    companion object {
        val CLIENT: Role
    }
}*/
