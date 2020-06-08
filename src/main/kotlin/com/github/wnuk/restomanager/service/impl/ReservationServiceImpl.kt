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
class ReservationServiceImpl(private val repository: ReservationRepository) : ReservationService {
    private val log = LoggerFactory.getLogger(ReservationServiceImpl::class.java)

    override fun deleteReservation(id: Long) {
        repository.deleteById(id)
    }

    override fun createReservation(reservationDto: ReservationDto): ReservationDto? {
        val reservationDao = reservationDto.toReservationDao()
        log.info("reservationDao = {}", reservationDao)
        repository.save(reservationDao)
        return reservationDao.toReservationDto()
    }

    override fun getReservationById(id: Long): ReservationDto? {
        val reservation = repository.findById(id).get()
        return reservation.toReservationDto()
    }

    override fun getReservationByDate(from: Long, to: Long): List<ReservationDto>? {
        return repository.findAllByDateBetween(Date(from), Date(to))?.map {
            it.toReservationDto()
        }
    }

    override fun getReservationByHours(from: Long, to: Long, date: Long): List<ReservationDto>? {
        return repository.findAllByTimeBetweenAndDateEquals(Time(from), Time(to), Date(date))?.map {
            it.toReservationDto()
        }
    }

    override fun getReservationByDateAndDate(fromDate: Long, toDate: Long, fromTime: Long, toTime: Long): List<ReservationDto>? {
        return repository.findAllByDateBetweenAndTimeBetween(Date(fromDate), Date(toDate), Time(fromTime), Time(toTime))?.map {
            it.toReservationDto()
        }
    }

    override fun getAllReservations(): List<ReservationDto>? {
        return repository.findAll().map {
            it.toReservationDto()
        }
    }
}