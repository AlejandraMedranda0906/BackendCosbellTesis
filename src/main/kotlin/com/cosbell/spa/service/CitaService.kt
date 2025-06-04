package com.cosbell.spa.service

import com.cosbell.spa.dto.CitaRequest
import com.cosbell.spa.entity.Cita
import com.cosbell.spa.repository.CitaRepository
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class CitaService(
    private val citaRepository: CitaRepository,
    private val javaMailSender: JavaMailSender
) {
    fun agendarCita(request: CitaRequest): Cita {
        if (citaRepository.existsByServicioIdAndFechaAndHora(request.servicioId, request.fecha, request.hora)) {
            throw Exception("Horario ocupado")
        }
        val cita = Cita(
            servicioId = request.servicioId,
            fecha = request.fecha,
            hora = request.hora,
            email = request.email
        )
        val saved = citaRepository.save(cita)
        enviarConfirmacionCita(request.email, "Tu cita fue agendada para el ${request.fecha} a las ${request.hora}.")
        return saved
    }

    fun enviarConfirmacionCita(email: String, mensaje: String) {
        val mail = SimpleMailMessage()
        mail.setTo(email)
        mail.setSubject("Confirmación de cita")
        mail.setText(mensaje)
        javaMailSender.send(mail)
    }
}