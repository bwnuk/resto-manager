package com.github.wnuk.restomanager.controller

import com.github.wnuk.restomanager.dto.BillDto
import com.github.wnuk.restomanager.dto.DishDto
import com.github.wnuk.restomanager.service.BillService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bill")
class BillController(private val service: BillService) {

    @GetMapping("/all")
    fun getAllDishes(): ResponseEntity<List<BillDto>> = ResponseEntity.ok(service.getBills())
}