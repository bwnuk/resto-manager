package com.github.wnuk.restomanager.controller

import com.github.wnuk.restomanager.dto.BillDto
import com.github.wnuk.restomanager.dto.DishDto
import com.github.wnuk.restomanager.service.BillService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/bill")
class BillController(private val service: BillService) {

    @GetMapping("/all")
    fun getAllDishes(): ResponseEntity<List<BillDto>> = ResponseEntity.ok(service.getBills())

    @GetMapping("/")
    fun getDishById(@RequestParam id: Long): ResponseEntity<BillDto> = ResponseEntity.ok(service.getBillById(id))

    @PostMapping("/add")
    fun addBill(@RequestBody billDto: BillDto): ResponseEntity<BillDto> = ResponseEntity.ok(service.addBill(billDto))
}