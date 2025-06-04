package com.cosbell.spa.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalTime

@Entity
data class Cita(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val servicioId: Long,
    val fecha: LocalDate,
    val hora: LocalTime,
    val email: String,
    val estado: String = "PENDIENTE"
)