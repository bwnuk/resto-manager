package com.github.wnuk.restomanager.service

import com.github.wnuk.restomanager.dto.DishDto

interface DishService {
    fun createDish(dish: DishDto): DishDto
    fun deleteDish(dish: DishDto)
    fun deleteDishById(id: Long)
    fun updatePrice(id: Long, price: Double): DishDto
    fun getDishByName(name: String): List<DishDto>
    fun getAllDishes(): List<DishDto>
}