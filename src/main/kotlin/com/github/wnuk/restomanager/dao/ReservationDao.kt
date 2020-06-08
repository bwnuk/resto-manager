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
        @Column()
        val createdBy: Long = 0,
        @Column()
        val tableId: Long = 0,
        @Column()
        val date: Date = Date.valueOf("2020-11-11"),
        @Column()
        val time: Time = Time.valueOf("00:00:00")
)

fun ReservationDao.toReservationDto() = ReservationDto(
        id = id,
        createdBy = createdBy,
        tableId = tableId,
        date = date,
        time = time)