package com.cosbell.spa.repository

import com.cosbell.spa.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Role, Long>{
    fun findByName(name: String): Role?
}
