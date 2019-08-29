package com.whitecloak.pets.controller.resource

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class PetResource(
        val name: String,
        val species: String,
        val breed: String,
        @JsonProperty("created_at")
        val createdAt: LocalDateTime
)

