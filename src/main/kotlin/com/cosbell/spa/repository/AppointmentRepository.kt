package com.cosbell.spa.repository

import com.cosbell.spa.entity.Appointment
import com.cosbell.spa.entity.Servicio
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate
import java.time.LocalTime

/*interface AppointmentRepository : JpaRepository<Appointment, Long> {
    fun existsByServicioIdAndFechaAndHora(servicioId: Long, fecha: LocalDate, hora: LocalTime): Boolean
    fun findByEmail(email: String): List<Appointment>*/


interface AppointmentRepository : JpaRepository<Appointment, Long> {
    fun existsByServicioAndDateAndTime(servicio: Servicio, date: LocalDate, time: LocalTime): Boolean
    fun findByEmail(email: String): List<Appointment>
}


