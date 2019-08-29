package com.whitecloak.pets.service

import com.whitecloak.pets.entity.PetEntity
import com.whitecloak.pets.entity.PizzaEntity
import com.whitecloak.pets.model.Pet
import com.whitecloak.pets.repository.PetRepository
import com.whitecloak.pets.service.exception.PetNotFoundException
import com.whitecloak.pets.service.mapper.PetGatewayMapper
import com.whitecloak.pets.service.param.PetParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class PetServiceImpl @Autowired constructor(
        val repository: PetRepository,
        val mapper: PetGatewayMapper
) : PetService {
    override fun index(): List<Pet> {
        return mapper.map(repository.findAll())
    }

    override fun store(param: PetParam): Pet {
        return mapper.mapOne(repository.save(PetEntity(
                name = param.name,
                species = param.species,
                breed = param.breed,
                createDate = LocalDateTime.now()
        )))
    }

    override fun show(id: Long): Pet {
        return mapper.mapOne(repository.findById(id).orElseThrow { PetNotFoundException() })
    }

    override fun update(id: Long, param: PetParam): Pet {
        val petEntity = repository.findById(id).orElseThrow { PetNotFoundException() }
        val updatedPetEntity = repository.save(PetEntity(
                id = petEntity.id,
                name = param.name,
                species = param.species,
                breed = param.breed,
                createDate = petEntity.createDate
        ))
        return mapper.mapOne(updatedPetEntity)
    }

    override fun destroy(id: Long) {
        repository.deleteById(id)
    }
}
