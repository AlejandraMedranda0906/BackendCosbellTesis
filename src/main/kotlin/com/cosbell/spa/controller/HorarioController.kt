package com.cosbell.spa.controller

import com.cosbell.spa.dto.HorarioRequest
import com.cosbell.spa.entity.Horario
import com.cosbell.spa.service.HorarioService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/horario")
class HorarioController(private val horarioService: HorarioService) {

    @GetMapping
    fun obtenerTodos(): List<Horario> = horarioService.findAll()

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Long): ResponseEntity<Horario> {
        val horario = horarioService.findById(id)
        return if (horario != null) ResponseEntity.ok(horario)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun crear(@RequestBody solicitud: HorarioRequest): Horario {
        val horario = Horario(
            dia = solicitud.dia,
            horaInicio = solicitud.horaInicio,
            horaFin = solicitud.horaFin
        )
        return horarioService.save(horario)
    }

    @PutMapping("/{id}")
    fun actualizar(@PathVariable id: Long, @RequestBody solicitud: HorarioRequest): ResponseEntity<Horario> {
        val existente = horarioService.findById(id)
        return if (existente != null) {
            val actualizado = horarioService.save(
                existente.copy(
                    dia = solicitud.dia,
                    horaInicio = solicitud.horaInicio,
                    horaFin = solicitud.horaFin
                )
            )
            ResponseEntity.ok(actualizado)
        } else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun eliminar(@PathVariable id: Long): ResponseEntity<Void> {
        return if (horarioService.findById(id) != null) {
            horarioService.deleteById(id)
            ResponseEntity.noContent().build()
        } else ResponseEntity.notFound().build()
    }
}
