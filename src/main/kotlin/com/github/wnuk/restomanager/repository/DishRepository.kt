package com.github.wnuk.restomanager.repository

import com.github.wnuk.restomanager.dao.DishDao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DishRepository: JpaRepository<DishDao, Long> {
    fun findAllByNameContains(name: String): MutableList<DishDao>
}