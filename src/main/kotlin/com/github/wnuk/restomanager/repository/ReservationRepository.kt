package com.github.wnuk.restomanager.repository

import com.github.wnuk.restomanager.dao.ReservationDao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.sql.Time
import java.util.*

@Repository
interface ReservationRepository : JpaRepository<ReservationDao, Long> {
    fun findAllByCreatedBy(name: Long): MutableList<ReservationDao>?
    fun findAllByDateBetween(from: Date, to: Date): MutableList<ReservationDao>?
    fun findAllByTimeBetweenAndDateEquals(from: Time, to: Time, date: Date): MutableList<ReservationDao>?
    fun findAllByDateBetweenAndTimeBetween(fromDate: Date, toDate: Date, fromTime: Time, toTime: Time): MutableList<ReservationDao>?
    fun findByTableId(name: Long): MutableList<ReservationDao>?
}