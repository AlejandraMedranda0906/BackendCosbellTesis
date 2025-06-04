package com.cosbell.spa.repository

import com.cosbell.spa.entity.Cita
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate
import java.time.LocalTime

interface CitaRepository : JpaRepository<Cita, Long> {
    fun existsByServicioIdAndFechaAndHora(servicioId: Long, fecha: LocalDate, hora: LocalTime): Boolean
    fun findByEmail(email: String): List<Cita>
}