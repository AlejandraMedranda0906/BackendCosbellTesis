package com.cosbell.spa.dto

import java.time.LocalDate
import java.time.LocalTime

data class CitaRequest(
    val servicioId: Long,
    val fecha: LocalDate,
    val hora: LocalTime,
    val email: String
)