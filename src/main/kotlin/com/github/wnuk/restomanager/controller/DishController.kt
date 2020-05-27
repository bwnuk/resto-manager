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
}