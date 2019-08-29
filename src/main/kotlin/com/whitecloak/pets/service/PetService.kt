package com.whitecloak.pets.service

import com.whitecloak.pets.model.Pet
import com.whitecloak.pets.service.param.PetParam

interface PetService {
    fun index(): List<Pet>
    fun store(param: PetParam): Pet
    fun show(id: Long): Pet
    fun update(id: Long, param: PetParam): Pet
    fun destroy(id: Long)
}
