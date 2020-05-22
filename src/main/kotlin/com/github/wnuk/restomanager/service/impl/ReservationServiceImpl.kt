package com.github.wnuk.restomanager.service.impl

import com.github.wnuk.restomanager.dao.toReservationDto
import com.github.wnuk.restomanager.dao.toUserDto
import com.github.wnuk.restomanager.dto.ReservationDto
import com.github.wnuk.restomanager.dto.toReservationDao
import com.github.wnuk.restomanager.repository.ReservationRepository
import com.github.wnuk.restomanager.repository.UserRepository
import com.github.wnuk.restomanager.service.ReservationService
import org.springframework.stereotype.Service

@Service
class ReservationServiceImpl(private val repository: ReservationRepository, private val userRepository: UserRepository) : ReservationService {
    override fun deleteReservation(id: Long) {
        repository.deleteById(id)
    }

    override fun createReservation(reservationDto: ReservationDto): ReservationDto? {
        val reservationDao = reservationDto.toReservationDao()
        repository.save(reservationDao)
        val user = userRepository.findById(reservationDao.createdBy)
        return reservationDao.toReservationDto(user.get().toUserDto())
    }

    override fun getReservationById(id: Long): ReservationDto? {
        val reservation = repository.findById(id).get()
        val user = userRepository.findById(reservation.createdBy)
        return reservation.toReservationDto(user.get().toUserDto())
    }

    override fun getReservationByDate(from: Long, to: Long): MutableList<ReservationDto>? {
        TODO("Not yet implemented")
    }

    override fun getAllReservations(): List<ReservationDto>? {
        return repository.findAll().map {
            val user = userRepository.findById(it.createdBy)
            it.toReservationDto(user.get().toUserDto())
        }
    }
}