package com.github.wnuk.restomanager.dto

import com.github.wnuk.restomanager.dao.ReservationDao
import java.sql.Date
import java.sql.Time

data class ReservationDto(
        val id: Long = 0,
        var createdBy: UserDto,
        val tableId: Long = 0,
        val date: Date = Date.valueOf("11-11-2020"),
        val time: Time = Time.valueOf("00:00")
)

fun ReservationDto.toReservationDao() = ReservationDao(
        id = id,
        createdBy = createdBy.id,
        tableId = tableId,
        date = date,
        time = time)