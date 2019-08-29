package com.whitecloak.pets.model

import java.time.LocalDateTime

data class Pet(
        val id: Long,
        val name: String,
        val species: String,
        val breed: String,
        val createDate: LocalDateTime
)
