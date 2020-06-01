package com.github.wnuk.restomanager.dto

import com.github.wnuk.restomanager.dao.BillDao
import com.github.wnuk.restomanager.dao.DishDao
import com.github.wnuk.restomanager.dao.UserDao

data class BillDto(
        val id: Long,
        val tableId: Long,
        var dishes: List<DishDto>,
        var sum: Double,
        val user: UserDto
)

fun BillDto.toBillDao(dishes: List<DishDao>, userDao: UserDao) = BillDao(
        id,
        tableId,
        dishes,
        sum,
        userDao
)