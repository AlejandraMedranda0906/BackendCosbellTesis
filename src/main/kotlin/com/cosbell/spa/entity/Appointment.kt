package com.cosbell.spa.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalTime

@Entity
@Table(name = "appointment")
data class Appointment(


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id", nullable = false)
    val servicio: Servicio,

    @Column(nullable = false)
    val date: LocalDate,

    @Column(nullable = false)
    val time: LocalTime,

    @Column(nullable = false)
    val email: String,

    @Column(nullable = false)
    val status: String = "PENDING"
)
