package com.cosbell.spa.controller

import com.cosbell.spa.entity.Servicio
import com.cosbell.spa.service.ServiceService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/servicio")
class ServicioController(private val servicioService: ServiceService) {


    @GetMapping
    fun getAllServicios(): List<Servicio> = servicioService.findAll()

    @GetMapping("/{id}")
    fun getServicioById(@PathVariable id: Long): ResponseEntity<Servicio> {
        val servicio = servicioService.findById(id)
        return if (servicio != null) ResponseEntity.ok(servicio)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createServicio(@RequestBody servicio: Servicio): Servicio = servicioService.save(servicio)

    @PutMapping("/{id}")
    fun updateServicio(@PathVariable id: Long, @RequestBody updated: Servicio): ResponseEntity<Servicio> {
        val servicio = servicioService.findById(id)
        return if (servicio != null) {
            val servicioActualizado = servicioService.save(updated.copy(id = id))
            ResponseEntity.ok(servicioActualizado)
        } else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteServicio(@PathVariable id: Long): ResponseEntity<Void> {
        return if (servicioService.findById(id) != null) {
            servicioService.deleteById(id)
            ResponseEntity.noContent().build()
        } else ResponseEntity.notFound().build()
    }
}