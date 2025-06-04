package com.cosbell.spa.service

import com.cosbell.spa.entity.Servicio
import com.cosbell.spa.repository.ServicioRepository
import org.springframework.stereotype.Service

@Service
class ServicioService(private val servicioRepository: ServicioRepository) {
    fun getAllServicios(): List<Servicio> = servicioRepository.findAll()
}