package com.domain.sub.models

import jakarta.persistence.*

// javax persistence -> jakarta persistence
@Entity
@Table(name = "person")
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "first_name", nullable = false, length = 80)
    var firstName: String = "",

    @Column(name = "last_name", nullable = false, length = 80)
    var lastName: String = "",
    @Column(nullable = false, length = 100)
    var address: String = "",
    @Column(nullable = false, length = 80)
    var gender: String = "",

    )