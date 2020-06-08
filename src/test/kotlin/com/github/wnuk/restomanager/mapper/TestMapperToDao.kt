package com.github.wnuk.restomanager.mapper

import com.github.wnuk.restomanager.dao.*
import com.github.wnuk.restomanager.dto.*
import junit.framework.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.sql.Date
import java.sql.Time

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestMapperToDao {
    @Test
    fun dishDao(){
        val dishDto = DishDto(1, "Rosol", 13.0)
        val dishDao = dishDto.toDishDao()
        Assert.assertEquals(dishDao.id, dishDto.id)
        Assert.assertEquals(1, dishDao.id)
        Assert.assertEquals(dishDao.name, dishDto.name)
        Assert.assertEquals("Rosol", dishDao.name)
        Assert.assertEquals(dishDao.price, dishDto.price)
        Assert.assertEquals(13.0, dishDao.price)
    }

    @Test
    fun userDao(){
        val userDto = UserDto(1, "admin", "admin1", "admin2", "admin3", ROLE.WAITER)
        val userDao = userDto.toUserDao()
        Assert.assertEquals(userDao.id, userDto.id)
        Assert.assertEquals(1, userDao.id)
        Assert.assertEquals(userDao.username, userDto.username)
        Assert.assertEquals("admin", userDao.username)
        Assert.assertEquals(userDao.firstname, userDto.firstname)
        Assert.assertEquals("admin1", userDao.firstname)
        Assert.assertEquals(userDao.lastname, userDto.lastname)
        Assert.assertEquals("admin2", userDao.lastname)
        Assert.assertEquals(userDao.password, userDto.password)
        Assert.assertEquals("admin3", userDao.password)
        Assert.assertEquals(userDao.role, userDto.role.toString())
        Assert.assertEquals("WAITER", userDao.role)
    }

    @Test
    fun ReservationDao(){
        val reservationDto = ReservationDto(1, 2, 3, Date.valueOf("2020-11-11"), Time.valueOf("00:00:00"))
        val reservationDao = reservationDto.toReservationDao()
        Assert.assertEquals(reservationDao.id, reservationDto.id)
        Assert.assertEquals(1, reservationDao.id)
        Assert.assertEquals(reservationDao.tableId, reservationDto.tableId)
        Assert.assertEquals(3, reservationDao.tableId)
        Assert.assertEquals(reservationDao.createdBy, reservationDto.createdBy)
        Assert.assertEquals(2, reservationDao.createdBy)
        Assert.assertEquals(reservationDao.date, reservationDto.date)
        Assert.assertEquals(Date.valueOf("2020-11-11"), reservationDao.date)
        Assert.assertEquals(reservationDao.time, reservationDto.time)
        Assert.assertEquals(Time.valueOf("00:00:00"), reservationDao.time)
    }

    @Test
    fun billDao(){
        val billDto = BillDto(1, 3, 15.0, 1)
        val userDao = UserDao(1, "admin", "admin1", "admin2", "admin3", "WAITER")
        val billDao = billDto.toBillDao(userDao)
        Assert.assertEquals(billDao.id, billDto.id)
        Assert.assertEquals(1, billDao.id)
        Assert.assertEquals(billDao.tableId, billDto.tableId)
        Assert.assertEquals(3, billDao.tableId)
        Assert.assertEquals(billDao.sum, billDto.sum)
        Assert.assertEquals(15.0, billDao.sum)
        Assert.assertEquals(billDao.user.id, billDto.user)
        Assert.assertEquals(1, billDao.user.id)
    }
}