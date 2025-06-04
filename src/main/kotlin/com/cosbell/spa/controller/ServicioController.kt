package com.cosbell.spa.controller

import com.cosbell.spa.entity.Servicio
import com.cosbell.spa.service.ServicioService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/servicios")
class ServicioController(private val servicioService: ServicioService) {

    @GetMapping
    fun getServicios(): List<Servicio> = servicioService.getAllServicios()
}