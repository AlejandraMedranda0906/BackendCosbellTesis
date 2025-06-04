package com.cosbell.spa.entity

import jakarta.persistence.*

@Entity
data class Servicio(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val nombre: String,
    val duracion: Int, // minutos
    val precio: Double
)