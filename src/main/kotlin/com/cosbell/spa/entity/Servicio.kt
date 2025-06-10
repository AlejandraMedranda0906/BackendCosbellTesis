package com.cosbell.spa.entity

import jakarta.persistence.*

@Entity
@Table(name = "service")
data class Servicio(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val duration: Int, // minutos
    val price: Double //BigDecimal
)