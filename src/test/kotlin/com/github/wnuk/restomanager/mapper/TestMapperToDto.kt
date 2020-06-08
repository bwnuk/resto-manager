package com.github.wnuk.restomanager.mapper

import com.github.wnuk.restomanager.dao.*
import com.github.wnuk.restomanager.dto.DishDto
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.sql.Date
import java.sql.Time
import junit.framework.Assert.assertEquals as assertEquals1

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestMapperToDto {

    @Test
    fun dishDto(){
        val dishDao = DishDao(1, "Rosol", 13.0)
        val dishDto = dishDao.toDishDto()
        assertEquals1(dishDao.id, dishDto.id)
        assertEquals1(1, dishDto.id)
        assertEquals1(dishDao.name, dishDto.name)
        assertEquals1("Rosol", dishDto.name)
        assertEquals1(dishDao.price, dishDto.price)
        assertEquals1(13.0, dishDto.price)
    }

    @Test
    fun userDto(){
        val userDao = UserDao(1, "admin", "admin1", "admin2", "admin3", "WAITER")
        val userDto = userDao.toUserDto()
        assertEquals1(userDao.id, userDto.id)
        assertEquals1(1, userDto.id)
        assertEquals1(userDao.username, userDto.username)
        assertEquals1("admin", userDto.username)
        assertEquals1(userDao.firstname, userDto.firstname)
        assertEquals1("admin1", userDto.firstname)
        assertEquals1(userDao.lastname, userDto.lastname)
        assertEquals1("admin2", userDto.lastname)
        assertEquals1(userDao.password, userDto.password)
        assertEquals1("admin3", userDto.password)
        assertEquals1(userDao.role, userDto.role.toString())
        assertEquals1("WAITER", userDto.role.toString())
    }

    @Test
    fun ReservationDto(){
        val reservationDao = ReservationDao(1, 2, 3, Date.valueOf("2020-11-11"), Time.valueOf("00:00:00"))
        val reservationDto = reservationDao.toReservationDto()
        assertEquals1(reservationDao.id, reservationDto.id)
        assertEquals1(1, reservationDto.id)
        assertEquals1(reservationDao.tableId, reservationDto.tableId)
        assertEquals1(3, reservationDto.tableId)
        assertEquals1(reservationDao.createdBy, reservationDto.createdBy)
        assertEquals1(2, reservationDto.createdBy)
        assertEquals1(reservationDao.date, reservationDto.date)
        assertEquals1(Date.valueOf("2020-11-11"), reservationDto.date)
        assertEquals1(reservationDao.time, reservationDto.time)
        assertEquals1(Time.valueOf("00:00:00"), reservationDto.time)
    }

    @Test
    fun billDto(){
        val userDao = UserDao(1, "admin", "admin1", "admin2", "admin3", "WAITER")
        val billDao = BillDao(1, 3, 15.0, userDao)
        val billDto = billDao.toBillDto()
        assertEquals1(billDao.id, billDto.id)
        assertEquals1(1, billDto.id)
        assertEquals1(billDao.tableId, billDto.tableId)
        assertEquals1(3, billDto.tableId)
        assertEquals1(billDao.sum, billDto.sum)
        assertEquals1(15.0, billDto.sum)
        assertEquals1(billDao.user.id, billDto.user)
        assertEquals1(1, billDto.user)
    }
}