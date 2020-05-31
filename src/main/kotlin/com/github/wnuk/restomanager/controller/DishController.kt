package com.github.wnuk.restomanager.controller

import com.github.wnuk.restomanager.dto.DishDto
import com.github.wnuk.restomanager.service.DishService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/dish")
class DishController(private val service: DishService){

    @PostMapping("/add")
    fun createDish(@RequestBody dish: DishDto): ResponseEntity<DishDto> = ResponseEntity.ok(service.createDish(dish))

    @DeleteMapping("/delete")
    fun deleteUser(@RequestParam id: Long): ResponseEntity<String>  {
        service.deleteDishById(id)
        return ResponseEntity.accepted().body("AA")
    }

    @PostMapping("/update")
    fun updateDish(@RequestBody dish: DishDto): ResponseEntity<DishDto> = ResponseEntity.ok(service.updateDish(dish))

    @PostMapping("/update")
    fun updateDish(@RequestParam id: Long, @RequestParam price: Double): ResponseEntity<DishDto> = ResponseEntity.ok(service.updatePrice(id, price))

    @GetMapping("")
    fun getDishByName(@RequestParam name: String): ResponseEntity<List<DishDto>> = ResponseEntity.ok(service.getDishByName(name))

    @GetMapping("/all")
    fun getAllDishes(): ResponseEntity<List<DishDto>> = ResponseEntity.ok(service.getAllDishes())
}