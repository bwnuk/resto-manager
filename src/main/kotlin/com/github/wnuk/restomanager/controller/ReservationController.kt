package com.github.wnuk.restomanager.controller

import com.github.wnuk.restomanager.dto.ReservationDto
import com.github.wnuk.restomanager.service.ReservationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/reservation")
class ReservationController(private var service: ReservationService) {

    @PostMapping("/add")
    fun createReservation(@RequestBody reservation: ReservationDto): ResponseEntity<ReservationDto> =
            ResponseEntity.accepted().body(service.createReservation(reservation))

    @DeleteMapping("/delete")
    fun deleteReservation(@RequestParam id: Long): ResponseEntity<String> {
        service.deleteReservation(id)
        return ResponseEntity.accepted().body("AA")
    }

    @GetMapping("")
    fun getReservationById(@RequestParam id: Long): ResponseEntity<ReservationDto> =
            ResponseEntity.ok().body(service.getReservationById(id))

    @GetMapping("")
    fun getReservationByDate(@RequestParam from: Long, @RequestParam(required = false) to: Long): ResponseEntity<List<ReservationDto>> =
            ResponseEntity.ok().body(service.getReservationByDate(from, to))

    @GetMapping("/all")
    fun getAllReservations(): ResponseEntity<List<ReservationDto>> =
            ResponseEntity.ok().body(service.getAllReservations())
}