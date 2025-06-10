package com.cosbell.spa.entity

import jakarta.persistence.*
import java.io.Serializable

@Entity
@Table(name = "role_permission")
@IdClass(RolePermissionId::class)
data class RolePermission(
    @Id
    @Column(name = "role_id")
    val roleId: Long,

    @Id
    @Column(name = "permission_id")
    val permissionId: Long
)

data class RolePermissionId(
    val roleId: Long = 0,
    val permissionId: Long = 0
): Serializable