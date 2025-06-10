package com.cosbell.spa.service

import com.cosbell.spa.dto.AppointmentDTO
import com.cosbell.spa.entity.Appointment
import com.cosbell.spa.entity.Servicio
import com.cosbell.spa.repository.AppointmentRepository
import com.cosbell.spa.repository.ServicioRepository
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class AppointmentService(
    private val appointmentRepository: AppointmentRepository,
    private val servicioRepository: ServicioRepository,
    private val javaMailSender: JavaMailSender
) {
    /*fun createAppointment(serviceId: Long, date: LocalDate, time: LocalTime, email: String): Appointment {
        if (AppointmentRepository.existsByServiceIdAndDateAndTime(serviceId, date, time)) {
            throw Exception("Horario ocupado")
        }*/
    fun createAppointment(request: AppointmentDTO): Appointment {
        val servicio = servicioRepository.findById(request.serviceId)
            .orElseThrow { Exception("Servicio no encontrado") }
       // val service = serviceRepository.findById(serviceId).orElseThrow { Exception("Servicio no encontrado") }
        if (appointmentRepository.existsByServicioAndDateAndTime(
                servicio,
                request.date,
                request.time
        ))
        {
            throw Exception("Horario ocupado")
        }
        val appointment = Appointment(
            servicio = Servicio,
            date = request.date,
            time = request.time,
            email = request.email
        )
        val saved = appointmentRepository.save(appointment)
        enviarConfirmacionCita(
            request.email, "Tu cita fue agendada para el ${request.date} a las ${request.time}.")
        return saved

    }

    private fun enviarConfirmacionCita(email: String, mensaje: String) {
        val mail = SimpleMailMessage()
        mail.setTo(email)
        mail.setSubject("Confirmación de cita")
        mail.setText(mensaje)
        javaMailSender.send(mail)
    }
}