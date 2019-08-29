package com.whitecloak.pets.entity

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "pets")
data class PizzaEntity(
        @Column @Id @GeneratedValue val id: Long? = null,
        @Column val name: String,
        @OneToMany val toppings: List<ToppingEntity>,
        @Column val createDate: LocalDateTime? = null
)
