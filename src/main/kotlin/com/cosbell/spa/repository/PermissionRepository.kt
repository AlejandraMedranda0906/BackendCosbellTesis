package com.cosbell.spa.repository

import com.cosbell.spa.entity.Permission
import org.springframework.data.jpa.repository.JpaRepository

interface PermissionRepository : JpaRepository<Permission, Long>
