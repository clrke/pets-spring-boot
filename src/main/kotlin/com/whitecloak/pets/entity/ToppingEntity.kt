package com.whitecloak.pets.entity

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "toppings")
data class ToppingEntity (
        @Column @Id @GeneratedValue val id: Long? = null,
        @Column val name: String,
        @ManyToOne val pizza: PizzaEntity,
        @Column val createDate: LocalDateTime? = null
)

