package com.utopiacloud.themyscira.themyscira.domain.entity

import javax.persistence.*


@Entity // This tells Hibernate to make a table out of this class
@Table(name = "user")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = 0,

        var name: String,

        var email: String
)