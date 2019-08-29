package com.whitecloak.pets.repository

import com.whitecloak.pets.entity.PetEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PetRepository : JpaRepository<PetEntity, Long> {

}
