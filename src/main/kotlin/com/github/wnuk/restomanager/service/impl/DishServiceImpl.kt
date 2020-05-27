package com.github.wnuk.restomanager.service.impl

import com.github.wnuk.restomanager.dao.toDishDto
import com.github.wnuk.restomanager.dto.DishDto
import com.github.wnuk.restomanager.dto.toDishDao
import com.github.wnuk.restomanager.repository.DishRepository
import com.github.wnuk.restomanager.service.DishService
import org.springframework.stereotype.Service

@Service
class DishServiceImpl(private val repository: DishRepository): DishService {
    override fun createDish(dish: DishDto): DishDto {
        val dishDao = dish.toDishDao()
        repository.save(dishDao)
        return dishDao.toDishDto()
    }

    override fun deleteDish(dish: DishDto) {
        repository.delete(dish.toDishDao())
    }

    override fun deleteDishById(id: Long) {
        repository.deleteById(id)
    }

    override fun updatePrice(id: Long, price: Double): DishDto {
        var dishDao = repository.findById(id)
        dishDao.get().price = price
        repository.save(dishDao.get())
        return dishDao.get().toDishDto()
    }

    override fun getDishByName(name: String): List<DishDto> {
        return repository.findAllByNameContains(name).map { it.toDishDto() }
    }

    override fun getAllDishes(): List<DishDto> {
        return repository.findAll().map { it.toDishDto() }
    }
}