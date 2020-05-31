package com.github.wnuk.restomanager.dao

import com.github.wnuk.restomanager.dto.DishDto
import javax.persistence.*
import javax.validation.constraints.NotBlank


@Entity
@Table
data class DishDao(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @get: NotBlank
        val name: String,
        @get: NotBlank
        var price: Double
)

fun DishDao.toDishDto() = DishDto(
        id = id,
        name = name,
        price = price)