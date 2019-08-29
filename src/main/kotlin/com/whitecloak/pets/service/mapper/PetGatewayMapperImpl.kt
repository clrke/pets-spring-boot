package com.whitecloak.pets.service.mapper

import com.whitecloak.pets.entity.PetEntity
import com.whitecloak.pets.model.Pet
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class PetGatewayMapperImpl : PetGatewayMapper {
    override fun map(petEntities: List<PetEntity>): List<Pet> {
        return petEntities.stream()
                .map(this::mapOne)
                .collect(Collectors.toList())
    }

    override fun mapOne(entity: PetEntity): Pet {
        return Pet(
                entity.id!!,
                entity.name,
                entity.species,
                entity.breed,
                entity.createDate!!
        )
    }
}