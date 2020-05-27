package com.github.wnuk.restomanager.dto

import com.github.wnuk.restomanager.dao.DishDao

data class DishDto(
        val id: Long,
        val name: String,
        var price: Double
)

fun DishDto.toDishDao() = DishDao(
        id, name, price
)