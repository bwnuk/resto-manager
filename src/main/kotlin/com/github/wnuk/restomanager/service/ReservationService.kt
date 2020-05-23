package com.github.wnuk.restomanager.service

import com.github.wnuk.restomanager.dto.ReservationDto

interface ReservationService {
    fun deleteReservation(id: Long)
    fun createReservation(reservationDto: ReservationDto): ReservationDto?
    fun getReservationById(id: Long): ReservationDto?
    fun getReservationByDate(from: Long, to: Long): List<ReservationDto>?
    fun getReservationByHours(from: Long, to: Long, date: Long): List<ReservationDto>?
    fun getReservationByDateAndDate(fromDate: Long, toDate: Long, fromTime: Long, toTime: Long): List<ReservationDto>?

    fun getAllReservations(): List<ReservationDto>?
}