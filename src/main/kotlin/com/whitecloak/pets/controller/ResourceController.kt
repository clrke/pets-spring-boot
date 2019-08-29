package com.whitecloak.pets.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

interface ResourceController<F, R, I> {
    @GetMapping("/")
    fun index(): List<R>

    @PostMapping("/")
    fun store(@RequestBody form: F): R

    @GetMapping("/{id}")
    fun show(@PathVariable id: I): R

    @PutMapping("/{id}")
    fun update(@PathVariable id: I, @RequestBody form: F): R

    @DeleteMapping("/{id}")
    fun destroy(id: I)
}
