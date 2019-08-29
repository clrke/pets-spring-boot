package com.whitecloak.pets.controller

import com.whitecloak.pets.controller.form.PetForm
import com.whitecloak.pets.controller.mapper.PetResourceMapper
import com.whitecloak.pets.controller.resource.PetResource
import com.whitecloak.pets.service.PetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/api/pets")
class PetController @Autowired constructor(
        val service: PetService,
        val mapper: PetResourceMapper
) : ResourceController<PetForm, PetResource, Long> {
    @GetMapping
    override fun index(): List<PetResource> {
        return mapper.map(service.index())
    }

    @PostMapping
    override fun store(form: PetForm): PetResource {
        return mapper.mapOne(service.store(mapper.mapToParam(form)))
    }

    @GetMapping("/{id}")
    override fun show(@PathVariable id: Long): PetResource {
        return mapper.mapOne(service.show(id))
    }

    @PutMapping("/{id}")
    override fun update(@PathVariable id: Long, @RequestBody form: PetForm): PetResource {
        return mapper.mapOne(service.update(id, mapper.mapToParam(form)))
    }

    @DeleteMapping("/{id}")
    override fun destroy(@PathVariable id: Long) {
        service.destroy(id)
    }
}