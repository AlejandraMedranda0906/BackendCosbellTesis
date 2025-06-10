package com.cosbell.spa.dto

import java.time.LocalDate
import java.time.LocalTime

data class AppointmentDTO(
    val serviceId: Long,
    val date: LocalDate,
    val time: LocalTime,
    val email: String
)
