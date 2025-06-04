package com.cosbell.spa.controller

import com.cosbell.spa.dto.CitaRequest
import com.cosbell.spa.entity.Cita
import com.cosbell.spa.service.CitaService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/citas")
class CitaController(private val citaService: CitaService) {

    @PostMapping
    fun agendarCita(@RequestBody request: CitaRequest): Cita {
        return citaService.agendarCita(request)
    }
}