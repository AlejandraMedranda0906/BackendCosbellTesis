package com.cosbell.spa.repository

import com.cosbell.spa.entity.Horario
import org.springframework.data.jpa.repository.JpaRepository

interface HorarioRepository : JpaRepository<Horario, Long>
