package com.cosbell.spa.controller

import com.cosbell.spa.dto.AppointmentDTO
import com.cosbell.spa.entity.Appointment
import com.cosbell.spa.service.AppointmentService
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.time.LocalTime

@RestController
@RequestMapping("/api/appointment")
class AppointmentController(private val appointmentService: AppointmentService) {
    @PostMapping
    fun create(@RequestBody request: AppointmentDTO): Appointment =
        appointmentService.createAppointment(request)
}
