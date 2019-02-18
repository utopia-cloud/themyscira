package com.utopiacloud.themyscira.themyscira.trial

import javax.persistence.*


@Entity
@Table(name = "trial_people")
data class Person(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = 0,

        var lastName: String,
        var firstName: String
)