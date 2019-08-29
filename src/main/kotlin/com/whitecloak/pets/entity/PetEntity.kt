package com.whitecloak.pets.entity

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "pets")
data class PetEntity(
        @Column @Id @GeneratedValue val id: Long? = null,
        @Column val name: String,
        @Column val species: String,
        @Column val breed: String,
        @Column val createDate: LocalDateTime? = null
)
