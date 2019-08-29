package com.whitecloak.pets.controller.mapper

import com.whitecloak.pets.controller.form.PetForm
import com.whitecloak.pets.controller.resource.PetResource
import com.whitecloak.pets.model.Pet
import com.whitecloak.pets.service.param.PetParam

interface PetResourceMapper {
    fun map(pets: List<Pet>): List<PetResource>
    fun mapOne(pet: Pet): PetResource
    fun mapToParam(form: PetForm): PetParam
}
