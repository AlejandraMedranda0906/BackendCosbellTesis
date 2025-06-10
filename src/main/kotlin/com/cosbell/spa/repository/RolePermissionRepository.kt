package com.cosbell.spa.repository

import com.cosbell.spa.entity.RolePermission
import com.cosbell.spa.entity.RolePermissionId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RolePermissionRepository : JpaRepository<RolePermission, RolePermissionId>
