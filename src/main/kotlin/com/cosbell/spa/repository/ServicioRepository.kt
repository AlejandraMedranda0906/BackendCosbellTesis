package com.cosbell.spa.repository

import com.cosbell.spa.entity.Servicio
import org.springframework.data.jpa.repository.JpaRepository

interface ServicioRepository : JpaRepository<Servicio, Long>