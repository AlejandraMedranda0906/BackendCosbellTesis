package com.cosbell.spa.repository

import org.springframework.data.jpa.repository.JpaRepository
import java.security.Provider.Service

interface ServicioRepository : JpaRepository<Service, Long>