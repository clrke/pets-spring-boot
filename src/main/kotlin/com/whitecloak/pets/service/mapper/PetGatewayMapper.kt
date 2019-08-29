package com.whitecloak.pets.service.mapper

import com.whitecloak.pets.entity.PetEntity
import com.whitecloak.pets.model.Pet

interface PetGatewayMapper {
    fun map(petEntities: List<PetEntity>): List<Pet>

    fun mapOne(entity: PetEntity): Pet
}
