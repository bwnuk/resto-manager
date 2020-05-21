package com.github.wnuk.restomanager.dto

import com.github.wnuk.restomanager.dao.ROLE
import com.github.wnuk.restomanager.dao.UserDao


class UserDto (
        var id: Long = -1,
        val username: String = "",
        val firstname: String = "",
        val lastname: String = "",
        val password: String = "",
        var role: ROLE
)

fun UserDto.toUserDao() = UserDao(
        id = id,
        username = username,
        firstname = firstname,
        lastname = lastname,
        password = password,
        role = role.toString()
)
