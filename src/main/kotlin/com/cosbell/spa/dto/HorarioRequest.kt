package com.cosbell.spa.dto

import java.time.LocalTime

data class HorarioRequest(
    val profesionalId: Long,
    val diaSemana: String, // Ej: "LUNES"
    val horaInicio: LocalTime,
    val horaFin: LocalTime
)