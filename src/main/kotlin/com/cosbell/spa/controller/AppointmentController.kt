package com.cosbell.spa.controller

import com.cosbell.spa.dto.AppointmentDTO
import com.cosbell.spa.entity.Appointment
import com.cosbell.spa.service.AppointmentService
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.time.LocalTime

@RestController
@RequestMapping("/api/appointment")
class AppointmentController(
    private val appointmentService: AppointmentService) {

    /*data class CreateAppointmentRequest(
        val serviceId: Long,
        val date: LocalDate,
        val time: LocalTime,
        val email: String
    )*/

    @PostMapping
    fun createAppointment(@RequestBody request: AppointmentDTO): Appointment {
        return appointmentService.createAppointment(request)

            /*request.serviceId,
            request.date,
            request.time,
            request.email,*/
    }

}

