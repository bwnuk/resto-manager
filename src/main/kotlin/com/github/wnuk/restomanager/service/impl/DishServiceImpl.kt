package com.github.wnuk.restomanager.service.impl

import com.github.wnuk.restomanager.dao.toDishDto
import com.github.wnuk.restomanager.dto.DishDto
import com.github.wnuk.restomanager.dto.toDishDao
import com.github.wnuk.restomanager.exception.CustomException
import com.github.wnuk.restomanager.repository.DishRepository
import com.github.wnuk.restomanager.service.DishService
import org.springframework.stereotype.Service

@Service
class DishServiceImpl(private val repository: DishRepository) : DishService {
    override fun createDish(dish: DishDto): DishDto {
        val dishDao = dish.toDishDao()
        repository.save(dishDao)
        return dishDao.toDishDto()
    }

    override fun deleteDish(dish: DishDto) {
        val dishDao = repository.findById(dish.id)
        if (dishDao.isEmpty){
            throw CustomException("Dish Not Found")
        }
        dishDao.ifPresent { repository.delete(dish.toDishDao()) }
    }

    override fun deleteDishById(id: Long) {
        val dishDao = repository.findById(id)
        if (dishDao.isEmpty){
            throw CustomException("Dish Not Found")
        }
        dishDao.ifPresent { repository.deleteById(id) }
    }

    override fun updatePrice(id: Long, price: Double): DishDto {
        val dishDao = repository.findById(id)
        if (dishDao.isEmpty){
            throw CustomException("Dish Not Found")
        }

        dishDao.ifPresent {
            it.price = price
            repository.save(it)
        }
        return dishDao.get().toDishDto()
    }

    override fun updateDish(dish: DishDto): DishDto {
        val dishDao = repository.findById(dish.id)
        if (dishDao.isEmpty){
            throw CustomException("Dish Not Found")
        }
        dishDao.ifPresent {
            it.price = dish.price
            repository.save(it)
        }

        return dishDao.get().toDishDto()
    }

    override fun getDishByName(name: String): List<DishDto> {
        return repository.findAllByNameContains(name).map { it.toDishDto() }.ifEmpty { return emptyList() }
    }

    override fun getAllDishes(): List<DishDto> {
        return repository.findAll().map { it.toDishDto() }.ifEmpty {  throw CustomException("No dishes")}
    }
}