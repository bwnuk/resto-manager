package com.github.wnuk.restomanager.repository

import com.github.wnuk.restomanager.dao.ReservationDao
import com.github.wnuk.restomanager.dao.UserDao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ReservationRepository  : JpaRepository<ReservationDao, Long> {
    fun findAllByCreatedBy(name: Long): MutableList<ReservationDao>?
    fun findByTableId(name: Long): MutableList<ReservationDao>?
}