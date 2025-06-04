package com.cosbell.spa.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(nullable = false, length = 50)
    var name: String,

    @Column(nullable = false, unique = true, length = 50)
    var email: String,

    @Column(nullable = false, length = 100)
    var password: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    var role: Role = Role.CLIENT
)

   //var locked: Boolean = false,
    //var disabled: Boolean = false)

   /* @OneToMany(mappedBy= "users", fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    var role: List<Role>? = null*/




    /*@Column(nullable = false)
        var locked: Boolean = false

    @Column(nullable = false)
        var disabled: Boolean = false*/








