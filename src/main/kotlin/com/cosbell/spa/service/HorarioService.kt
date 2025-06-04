package com.cosbell.spa.service

import Horario
import com.cosbell.spa.dto.HorarioRequest
import com.cosbell.spa.repository.HorarioRepository
import org.springframework.stereotype.Service

@Service
class HorarioService(private val horarioRepository: HorarioRepository) {
    fun crearHorario(request: HorarioRequest): Horario {
        // Aquí puedes agregar validación de solapamiento de horarios si lo deseas
        val horario = Horario(
            profesionalId = request.profesionalId,
            diaSemana = request.diaSemana,
            horaInicio = request.horaInicio,
            horaFin = request.horaFin
        )
        return horarioRepository.save(horario)
    }
}