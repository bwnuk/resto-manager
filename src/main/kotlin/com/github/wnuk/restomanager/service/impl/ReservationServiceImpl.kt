package com.github.wnuk.restomanager.service.impl

import com.github.wnuk.restomanager.dao.toReservationDto
import com.github.wnuk.restomanager.dao.toUserDto
import com.github.wnuk.restomanager.dto.ReservationDto
import com.github.wnuk.restomanager.dto.toReservationDao
import com.github.wnuk.restomanager.repository.ReservationRepository
import com.github.wnuk.restomanager.repository.UserRepository
import com.github.wnuk.restomanager.service.ReservationService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.sql.Time
import java.util.*

@Service
class ReservationServiceImpl(private val repository: ReservationRepository, private val userRepository: UserRepository) : ReservationService {
    private val log = LoggerFactory.getLogger(ReservationServiceImpl::class.java)

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

    override fun getReservationByDate(from: Long, to: Long): List<ReservationDto>? {
        return repository.findAllByDateBetween(Date(from), Date(to))?.map {
            val user = userRepository.findById(it.createdBy)
            it.toReservationDto(user.get().toUserDto())
        }
    }

    override fun getReservationByHours(from: Long, to: Long, date: Long): List<ReservationDto>? {
        return repository.findAllByTimeBetweenAndDateEquals(Time(from), Time(to), Date(date))?.map {
            val user = userRepository.findById(it.createdBy)
            it.toReservationDto(user.get().toUserDto())
        }
    }

    override fun getReservationByDateAndDate(fromDate: Long, toDate: Long, fromTime: Long, toTime: Long): List<ReservationDto>? {
        return repository.findAllByDateBetweenAndTimeBetween(Date(fromDate), Date(toDate), Time(fromTime), Time(toTime))?.map {
            val user = userRepository.findById(it.createdBy)
            it.toReservationDto(user.get().toUserDto())
        }
    }

    override fun getAllReservations(): List<ReservationDto>? {
        return repository.findAll().map {
            val user = userRepository.findById(it.createdBy)
            it.toReservationDto(user.get().toUserDto())
        }
    }
}