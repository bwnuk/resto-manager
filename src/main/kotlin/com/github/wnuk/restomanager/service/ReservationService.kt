package com.github.wnuk.restomanager.service

import com.github.wnuk.restomanager.dto.ReservationDto

interface ReservationService {
    fun deleteReservation(id: Long)
    fun createReservation(reservationDto: ReservationDto): ReservationDto?
    fun getReservationById(id: Long): ReservationDto?
    fun getReservationByDate(from: Long, to: Long): MutableList<ReservationDto>?
    fun getAllReservations(): List<ReservationDto>?
}