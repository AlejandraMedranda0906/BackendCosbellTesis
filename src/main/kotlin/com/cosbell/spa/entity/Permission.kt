package com.cosbell.spa.entity

import jakarta.persistence.*

@Entity
@Table(name = "permission")
data class Permission(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "resource_path", nullable = false)
    val resourcePath: String,

    @Column(name = "http_method", nullable = false)
    val httpMethod: String
)
