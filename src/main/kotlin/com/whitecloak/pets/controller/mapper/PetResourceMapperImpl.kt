package com.whitecloak.pets.controller.mapper

import com.whitecloak.pets.controller.form.PetForm
import com.whitecloak.pets.controller.resource.PetResource
import com.whitecloak.pets.model.Pet
import com.whitecloak.pets.service.param.PetParam
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class PetResourceMapperImpl : PetResourceMapper {
    override fun map(pets: List<Pet>): List<PetResource> {
        return pets.stream()
                .map(this::mapOne)
                .collect(Collectors.toList())
    }

    override fun mapOne(pet: Pet): PetResource {
        return PetResource(
                pet.name,
                pet.species,
                pet.breed,
                pet.createDate
        )
    }

    override fun mapToParam(form: PetForm): PetParam {
        return PetParam(
                form.name,
                form.species,
                form.breed
        )
    }

}