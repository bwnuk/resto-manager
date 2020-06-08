package com.github.wnuk.restomanager.dto

import com.github.wnuk.restomanager.dao.BillDao
import com.github.wnuk.restomanager.dao.DishDao
import com.github.wnuk.restomanager.dao.UserDao

data class BillDto(
        val id: Long,
        val tableId: Long,
        var sum: Double,
        val user: Long
)

fun BillDto.toBillDao(userDao: UserDao) = BillDao(
        id,
        tableId,
        sum,
        userDao
)