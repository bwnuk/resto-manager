package com.github.wnuk.restomanager.dao

import com.github.wnuk.restomanager.dto.ReservationDto
import com.github.wnuk.restomanager.dto.UserDto
import java.sql.Date
import java.sql.Time
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table
data class ReservationDao(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,
        @get: NotBlank
        val createdBy: Long = 0,
        @get: NotBlank
        val tableId: Long = 0,
        @get: NotBlank
        val date: Date = Date.valueOf("11-11-2020"),
        @get: NotBlank
        val time: Time = Time.valueOf("00:00")
)

fun ReservationDao.toReservationDto(createdBy: UserDto) = ReservationDto(
        id = id,
        createdBy = createdBy,
        tableId = tableId,
        date = date,
        time = time)