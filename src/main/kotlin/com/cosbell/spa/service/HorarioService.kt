package com.cosbell.spa.service

import com.cosbell.spa.entity.Horario
import com.cosbell.spa.repository.HorarioRepository
import org.springframework.stereotype.Service

@Service
class HorarioService(private val horarioRepository: HorarioRepository) {

    fun findAll(): List<Horario> = horarioRepository.findAll()

    fun findById(id: Long): Horario? = horarioRepository.findById(id).orElse(null)

    fun save(horario: Horario): Horario = horarioRepository.save(horario)

    fun deleteById(id: Long) = horarioRepository.deleteById(id)
}
