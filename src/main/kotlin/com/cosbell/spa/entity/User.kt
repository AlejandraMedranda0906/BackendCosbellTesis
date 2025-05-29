package com.cosbell.spa.entity

import jakarta.persistence.*


@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(nullable = false, unique = true, length = 20)
    var name: String,

    @Column(nullable = false, unique = true, length = 50)
    var email: String,

    @Column(nullable = false, length = 100)
    var password: String,

    @Enumerated(EnumType.STRING)
    var role: Role


)
    /*@Column(nullable = false)
        var locked: Boolean = false

    @Column(nullable = false)
        var disabled: Boolean = false*/








