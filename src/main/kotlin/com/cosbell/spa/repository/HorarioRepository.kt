package com.cosbell.spa.repository

import Horario
import org.springframework.data.jpa.repository.JpaRepository

interface HorarioRepository : JpaRepository<Horario, Long>