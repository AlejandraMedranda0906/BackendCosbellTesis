package com.cosbell.spa.service

import com.cosbell.spa.entity.Servicio
import com.cosbell.spa.repository.ServicioRepository

//@org.springframework.stereotype.Service
//class ServiceService(private val servicioRepository: ServiceRepository) {
  //  fun getAllServicios(): List<com.cosbell.spa.entity.Service> = servicioRepository.findAll()
//}

@org.springframework.stereotype.Service
class ServiceService(private val servicioRepository: ServicioRepository) {

    fun findAll(): List<Servicio> = servicioRepository.findAll()

    fun findById(id: Long): Servicio? = servicioRepository.findById(id).orElse(null)

    fun save(servicio: Servicio): Servicio = servicioRepository.save(servicio)

    fun deleteById(id: Long) = servicioRepository.deleteById(id)
}

